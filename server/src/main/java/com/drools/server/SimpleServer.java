package com.drools.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import com.drools.proto.RuleRequest;
import com.drools.proto.RuleResponse;
import com.drools.proto.AddRuleRequest;
import com.drools.proto.AddRuleResponse;
import com.drools.proto.RuleEngineServiceGrpc;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class SimpleServer {
    private Server server;
    private static final int PORT = 50051;
    private KieContainer kContainer;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("启动Drools规则引擎gRPC服务器...");
        System.out.println("监听端口: " + PORT);

        final SimpleServer server = new SimpleServer();
        server.initialize();
        server.start();
        server.blockUntilShutdown();
    }

    private void initialize() {
        try {
            KieServices kieServices = KieServices.Factory.get();
            kContainer = kieServices.getKieClasspathContainer();
            System.out.println("Drools规则引擎初始化成功");
        } catch (Exception e) {
            System.err.println("Drools规则引擎初始化失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void start() throws IOException {
        server = ServerBuilder.forPort(PORT)
                .addService(new RuleEngineServiceImpl(kContainer))
                .build()
                .start();

        System.out.println("服务器启动成功!");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            SimpleServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    static class RuleEngineServiceImpl extends RuleEngineServiceGrpc.RuleEngineServiceImplBase {

        private final KieContainer kContainer;

        public RuleEngineServiceImpl(KieContainer kContainer) {
            this.kContainer = kContainer;
        }

        @Override
        public void executeRule(RuleRequest request, StreamObserver<RuleResponse> responseObserver) {
            System.out.println("收到执行规则请求: " + request.getSessionId());

            Map<String, String> facts = new HashMap<>(request.getFactsMap());
            RuleResponse.Builder responseBuilder = RuleResponse.newBuilder();

            try {
                KieSession kSession = kContainer.newKieSession("ksession-rules");

                // 插入事实到规则引擎
                kSession.insert(facts);

                // 执行规则
                kSession.fireAllRules();

                // 设置结果
                responseBuilder.setSuccess(true);
                responseBuilder.putAllResults(facts);
                responseBuilder.addMessages("规则执行成功");

                kSession.dispose();

            } catch (Exception e) {
                System.err.println("规则执行错误: " + e.getMessage());
                e.printStackTrace();
                responseBuilder.setSuccess(false);
                responseBuilder.addMessages("规则执行错误: " + e.getMessage());
            }

            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        }

        @Override
        public void addRule(AddRuleRequest request, StreamObserver<AddRuleResponse> responseObserver) {
            System.out.println("收到添加规则请求: " + request.getRule().getRuleName());

            AddRuleResponse response = AddRuleResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("规则添加成功: " + request.getRule().getRuleName())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}