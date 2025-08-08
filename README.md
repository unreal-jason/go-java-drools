# Drools规则引擎Go语言Demo

这是一个展示如何结合Drools规则引擎和Go语言的完整示例项目。

## 项目架构

本项目采用混合架构：
- **Java服务端**: 基于Drools的规则引擎，通过gRPC提供服务
- **Go客户端**: 通过gRPC调用规则引擎服务

## 项目结构

```
drools-demo/
├── server/           # Java服务端代码
│   ├── pom.xml      # Maven配置文件
│   ├── GrpcServer.java          # gRPC服务器启动类
│   └── RuleEngineServiceImpl.java   # 规则引擎服务实现
├── client/          # Go客户端代码
│   └── rule_client.go    # gRPC客户端封装
├── proto/           # gRPC协议定义
│   └── rules.proto  # 规则引擎服务定义
├── main.go          # Go客户端演示程序
└── go.mod          # Go模块配置
```

## 快速开始

### 1. 启动Java规则引擎服务器

#### 前置要求
- Java 11或更高版本
- Maven 3.6+

#### 启动步骤
```bash
cd server
mvn compile exec:java
```

服务器将在 `localhost:50051` 启动。

### 2. 运行Go客户端

#### 前置要求
- Go 1.20或更高版本

#### 运行步骤
```bash
go mod tidy
go run main.go
```

## 功能演示

Go客户端将演示以下场景：

1. **VIP折扣规则**: 消费超过1000元的VIP客户享受9折优惠
2. **运费规则**: 重量超过10kg的商品需要额外运费
3. **普通客户测试**: 验证非VIP客户不享受折扣
4. **动态规则添加**: 运行时添加新客户礼品规则
5. **新客户规则**: 验证新客户礼品赠送规则

## 规则定义示例

### VIP折扣规则 (DRL格式)
```drl
rule "Discount Rule"
when
    Map( $amount : this["amount"], $customerType : this["customerType"] )
    eval( Double.parseDouble($amount.toString()) > 1000 && "VIP".equals($customerType) )
then
    Map results = new HashMap();
    results.put("discount", "0.9");
    results.put("message", "VIP客户享受9折优惠");
    insert(results);
end
```

## 开发说明

### 添加新规则

1. **服务端**: 修改 `RuleEngineServiceImpl.java` 中的基础规则
2. **客户端**: 通过 `AddRule` API 动态添加规则

### 扩展功能

- 支持更多数据类型（不只是Map）
- 添加规则持久化
- 支持规则模板
- 添加监控和日志

## 故障排除

### Java服务端启动失败
- 检查端口50051是否被占用
- 确认Java版本符合要求
- 检查Maven依赖是否正确下载

### Go客户端连接失败
- 确认Java服务端已启动
- 检查网络连接
- 确认gRPC端口配置正确

## 技术栈

- **规则引擎**: Drools 8.44.0.Final
- **通信协议**: gRPC
- **Java版本**: 11+
- **Go版本**: 1.20+
- **构建工具**: Maven + Go Modules

## 许可证

MIT License