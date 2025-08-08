package com.drools.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 规则引擎服务定义
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: rules.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RuleEngineServiceGrpc {

  private RuleEngineServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "drools.RuleEngineService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.drools.proto.RuleRequest,
      com.drools.proto.RuleResponse> getExecuteRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteRule",
      requestType = com.drools.proto.RuleRequest.class,
      responseType = com.drools.proto.RuleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.drools.proto.RuleRequest,
      com.drools.proto.RuleResponse> getExecuteRuleMethod() {
    io.grpc.MethodDescriptor<com.drools.proto.RuleRequest, com.drools.proto.RuleResponse> getExecuteRuleMethod;
    if ((getExecuteRuleMethod = RuleEngineServiceGrpc.getExecuteRuleMethod) == null) {
      synchronized (RuleEngineServiceGrpc.class) {
        if ((getExecuteRuleMethod = RuleEngineServiceGrpc.getExecuteRuleMethod) == null) {
          RuleEngineServiceGrpc.getExecuteRuleMethod = getExecuteRuleMethod =
              io.grpc.MethodDescriptor.<com.drools.proto.RuleRequest, com.drools.proto.RuleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecuteRule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drools.proto.RuleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drools.proto.RuleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RuleEngineServiceMethodDescriptorSupplier("ExecuteRule"))
              .build();
        }
      }
    }
    return getExecuteRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.drools.proto.AddRuleRequest,
      com.drools.proto.AddRuleResponse> getAddRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddRule",
      requestType = com.drools.proto.AddRuleRequest.class,
      responseType = com.drools.proto.AddRuleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.drools.proto.AddRuleRequest,
      com.drools.proto.AddRuleResponse> getAddRuleMethod() {
    io.grpc.MethodDescriptor<com.drools.proto.AddRuleRequest, com.drools.proto.AddRuleResponse> getAddRuleMethod;
    if ((getAddRuleMethod = RuleEngineServiceGrpc.getAddRuleMethod) == null) {
      synchronized (RuleEngineServiceGrpc.class) {
        if ((getAddRuleMethod = RuleEngineServiceGrpc.getAddRuleMethod) == null) {
          RuleEngineServiceGrpc.getAddRuleMethod = getAddRuleMethod =
              io.grpc.MethodDescriptor.<com.drools.proto.AddRuleRequest, com.drools.proto.AddRuleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddRule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drools.proto.AddRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drools.proto.AddRuleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RuleEngineServiceMethodDescriptorSupplier("AddRule"))
              .build();
        }
      }
    }
    return getAddRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.drools.proto.RuleRequest,
      com.drools.proto.RuleResponse> getExecuteRulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteRules",
      requestType = com.drools.proto.RuleRequest.class,
      responseType = com.drools.proto.RuleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.drools.proto.RuleRequest,
      com.drools.proto.RuleResponse> getExecuteRulesMethod() {
    io.grpc.MethodDescriptor<com.drools.proto.RuleRequest, com.drools.proto.RuleResponse> getExecuteRulesMethod;
    if ((getExecuteRulesMethod = RuleEngineServiceGrpc.getExecuteRulesMethod) == null) {
      synchronized (RuleEngineServiceGrpc.class) {
        if ((getExecuteRulesMethod = RuleEngineServiceGrpc.getExecuteRulesMethod) == null) {
          RuleEngineServiceGrpc.getExecuteRulesMethod = getExecuteRulesMethod =
              io.grpc.MethodDescriptor.<com.drools.proto.RuleRequest, com.drools.proto.RuleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecuteRules"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drools.proto.RuleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drools.proto.RuleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RuleEngineServiceMethodDescriptorSupplier("ExecuteRules"))
              .build();
        }
      }
    }
    return getExecuteRulesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RuleEngineServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuleEngineServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RuleEngineServiceStub>() {
        @java.lang.Override
        public RuleEngineServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RuleEngineServiceStub(channel, callOptions);
        }
      };
    return RuleEngineServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RuleEngineServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuleEngineServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RuleEngineServiceBlockingStub>() {
        @java.lang.Override
        public RuleEngineServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RuleEngineServiceBlockingStub(channel, callOptions);
        }
      };
    return RuleEngineServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RuleEngineServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuleEngineServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RuleEngineServiceFutureStub>() {
        @java.lang.Override
        public RuleEngineServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RuleEngineServiceFutureStub(channel, callOptions);
        }
      };
    return RuleEngineServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 规则引擎服务定义
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 执行规则
     * </pre>
     */
    default void executeRule(com.drools.proto.RuleRequest request,
        io.grpc.stub.StreamObserver<com.drools.proto.RuleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExecuteRuleMethod(), responseObserver);
    }

    /**
     * <pre>
     * 添加新规则
     * </pre>
     */
    default void addRule(com.drools.proto.AddRuleRequest request,
        io.grpc.stub.StreamObserver<com.drools.proto.AddRuleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddRuleMethod(), responseObserver);
    }

    /**
     * <pre>
     * 批量执行规则
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.drools.proto.RuleRequest> executeRules(
        io.grpc.stub.StreamObserver<com.drools.proto.RuleResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getExecuteRulesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RuleEngineService.
   * <pre>
   * 规则引擎服务定义
   * </pre>
   */
  public static abstract class RuleEngineServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RuleEngineServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RuleEngineService.
   * <pre>
   * 规则引擎服务定义
   * </pre>
   */
  public static final class RuleEngineServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RuleEngineServiceStub> {
    private RuleEngineServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuleEngineServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuleEngineServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 执行规则
     * </pre>
     */
    public void executeRule(com.drools.proto.RuleRequest request,
        io.grpc.stub.StreamObserver<com.drools.proto.RuleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecuteRuleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 添加新规则
     * </pre>
     */
    public void addRule(com.drools.proto.AddRuleRequest request,
        io.grpc.stub.StreamObserver<com.drools.proto.AddRuleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddRuleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 批量执行规则
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.drools.proto.RuleRequest> executeRules(
        io.grpc.stub.StreamObserver<com.drools.proto.RuleResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getExecuteRulesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RuleEngineService.
   * <pre>
   * 规则引擎服务定义
   * </pre>
   */
  public static final class RuleEngineServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RuleEngineServiceBlockingStub> {
    private RuleEngineServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuleEngineServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuleEngineServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 执行规则
     * </pre>
     */
    public com.drools.proto.RuleResponse executeRule(com.drools.proto.RuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteRuleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 添加新规则
     * </pre>
     */
    public com.drools.proto.AddRuleResponse addRule(com.drools.proto.AddRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddRuleMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RuleEngineService.
   * <pre>
   * 规则引擎服务定义
   * </pre>
   */
  public static final class RuleEngineServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RuleEngineServiceFutureStub> {
    private RuleEngineServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuleEngineServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuleEngineServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 执行规则
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.drools.proto.RuleResponse> executeRule(
        com.drools.proto.RuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecuteRuleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 添加新规则
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.drools.proto.AddRuleResponse> addRule(
        com.drools.proto.AddRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddRuleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXECUTE_RULE = 0;
  private static final int METHODID_ADD_RULE = 1;
  private static final int METHODID_EXECUTE_RULES = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXECUTE_RULE:
          serviceImpl.executeRule((com.drools.proto.RuleRequest) request,
              (io.grpc.stub.StreamObserver<com.drools.proto.RuleResponse>) responseObserver);
          break;
        case METHODID_ADD_RULE:
          serviceImpl.addRule((com.drools.proto.AddRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.drools.proto.AddRuleResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXECUTE_RULES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.executeRules(
              (io.grpc.stub.StreamObserver<com.drools.proto.RuleResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getExecuteRuleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.drools.proto.RuleRequest,
              com.drools.proto.RuleResponse>(
                service, METHODID_EXECUTE_RULE)))
        .addMethod(
          getAddRuleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.drools.proto.AddRuleRequest,
              com.drools.proto.AddRuleResponse>(
                service, METHODID_ADD_RULE)))
        .addMethod(
          getExecuteRulesMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.drools.proto.RuleRequest,
              com.drools.proto.RuleResponse>(
                service, METHODID_EXECUTE_RULES)))
        .build();
  }

  private static abstract class RuleEngineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RuleEngineServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.drools.proto.RulesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RuleEngineService");
    }
  }

  private static final class RuleEngineServiceFileDescriptorSupplier
      extends RuleEngineServiceBaseDescriptorSupplier {
    RuleEngineServiceFileDescriptorSupplier() {}
  }

  private static final class RuleEngineServiceMethodDescriptorSupplier
      extends RuleEngineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RuleEngineServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RuleEngineServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RuleEngineServiceFileDescriptorSupplier())
              .addMethod(getExecuteRuleMethod())
              .addMethod(getAddRuleMethod())
              .addMethod(getExecuteRulesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
