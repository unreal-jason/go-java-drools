# Drools规则引擎Go语言Demo

这是一个展示如何结合Drools规则引擎和Go语言的完整示例项目。项目已成功修复所有规则执行问题，现在可以正常运行所有演示功能。

## 项目架构

本项目采用混合架构：
- **Java服务端**: 基于Drools的规则引擎，通过gRPC提供服务，主程序为SimpleServer.java
- **Go客户端**: 通过gRPC调用规则引擎服务

## 项目结构

```
drools-demo/
├── server/                   # Java服务端代码
│   ├── pom.xml              # Maven配置文件
│   ├── start-server.bat     # Windows启动脚本
│   ├── Dockerfile           # Docker容器配置
│   ├── src/                 # Java源代码
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── drools/
│   │       │           └── server/
│   │       │               └── SimpleServer.java
│   │       └── resources/
│   │           ├── META-INF/
│   │           │   └── kmodule.xml      # Drools模块配置
│   │           └── rules/
│   │               └── customer-rules.drl  # 规则定义文件
│   └── target/              # Maven构建输出
├── client/                  # Go客户端代码
│   └── rule_client.go       # gRPC客户端封装
├── proto/                   # gRPC协议定义
│   ├── rules.proto          # 规则引擎服务定义
│   ├── rules.pb.go          # 生成的Go代码
│   └── rules_grpc.pb.go     # 生成的gRPC Go代码
├── run-client.bat           # Windows客户端运行脚本
├── Dockerfile.client        # Go客户端Docker配置
├── docker-compose.yml       # Docker Compose配置
├── main.go                  # Go客户端演示程序
├── go.mod                   # Go模块配置
├── go.sum                   # Go依赖锁定文件
└── drools-client.exe        # 编译好的Windows可执行文件
```

## 快速开始

### 1. 启动Java规则引擎服务器

#### 前置要求
- Java 11或更高版本
- Maven 3.6+

#### 启动方式一：使用Maven（推荐）
```bash
cd server
mvn clean compile exec:java
```

#### 启动方式二：使用批处理文件（Windows）
```bash
cd server
start-server.bat
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

1. **VIP折扣规则**: VIP客户享受15%折扣
2. **运费规则**: 根据区域（国内/国际）计算运费
3. **普通客户折扣**: 普通客户享受5%折扣
4. **新客户礼品**: 新客户赠送价值50元礼品
5. **动态规则添加**: 运行时添加和验证新规则

### 演示结果
- ✅ 所有规则执行成功
- ✅ gRPC通信正常
- ✅ 动态规则添加功能正常
- ✅ 数据返回格式正确

## 规则定义示例

### 当前规则文件 (customer-rules.drl)
```drl
package rules

import java.util.Map

// 基础测试规则
rule "TestRule"
    when
        $map : Map()
    then
        $map.put("testResult", "规则引擎工作正常");
        $map.put("status", "success");
end

// VIP客户折扣规则
rule "VIPDiscountRule"
    when
        $map : Map( get("customerType") == "VIP" )
    then
        $map.put("discount", "15%");
        $map.put("message", "VIP客户享受15%折扣");
end

// 普通客户折扣规则
rule "RegularDiscountRule"
    when
        $map : Map( get("customerType") == "普通" )
    then
        $map.put("discount", "5%");
        $map.put("message", "普通客户享受5%折扣");
end

// 新客户礼品规则
rule "NewCustomerRule"
    when
        $map : Map( get("isNewCustomer") == "true" )
    then
        $map.put("welcomeGift", "true");
        $map.put("giftValue", "50");
        $map.put("message", "新客户赠送价值50元礼品");
end

// 运费规则
rule "ShippingRule"
    when
        $map : Map( get("zone") != null )
    then
        if ("国内".equals($map.get("zone"))) {
            $map.put("shippingCost", "20");
            $map.put("message", "国内运费20元");
        } else if ("国际".equals($map.get("zone"))) {
            $map.put("shippingCost", "50");
            $map.put("message", "国际运费50元");
        };
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

### 已修复的问题
- ✅ **规则语法错误**: 修复了DRL文件中缺失分号的语法错误
- ✅ **缺少依赖**: 添加了`drools-mvel`依赖解决表达式语言问题
- ✅ **规则编译失败**: 修正了Map类型处理的语法

### 常见问题解决

#### Java服务端启动失败
- 检查端口50051是否被占用
- 确认Java版本符合要求（11+）
- 检查Maven依赖是否正确下载
- 查看控制台日志中的具体错误信息

#### Go客户端连接失败
- 确认Java服务端已启动并监听50051端口
- 检查网络连接
- 确认gRPC端口配置正确
- 检查防火墙设置

#### 规则执行错误
- 确认规则文件`customer-rules.drl`语法正确
- 检查规则包路径配置
- 验证kmodule.xml配置是否正确

### 调试技巧
1. 查看服务端控制台日志获取详细错误信息
2. 使用`TestRule`验证规则引擎基础功能
3. 逐步添加复杂规则进行测试

## 技术栈

- **规则引擎**: Drools 8.44.0.Final
- **通信协议**: gRPC
- **Java版本**: 11+
- **Go版本**: 1.20+
- **构建工具**: Maven + Go Modules

## 快速验证

项目已完全修复并测试通过，可以通过以下步骤快速验证：

1. **启动服务端**:
   ```bash
   cd server
   mvn clean compile exec:java
   ```

2. **运行客户端** (在新终端):
   ```bash
   go run main.go
   ```

3. **预期输出**: 所有演示场景应显示"规则执行成功"

## 项目状态

✅ **完全可用状态** - 所有功能已修复并测试通过
- 规则语法错误已修复
- 依赖问题已解决
- gRPC通信正常
- 所有演示场景正常工作

## 许可证

MIT License