FROM openjdk:11-jre-slim

WORKDIR /app

# 复制Maven文件
COPY pom.xml .
COPY src ./src

# 安装Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# 构建应用
RUN mvn clean compile

# 暴露端口
EXPOSE 50051

# 启动应用
CMD ["mvn", "exec:java"]