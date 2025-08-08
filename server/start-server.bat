@echo off
echo Starting Drools gRPC Server...
echo.

REM 检查Java版本
java -version >nul 2>&1
if errorlevel 1 (
    echo Error: Java is not installed or not in PATH
    echo Please install Java 11 or higher
    pause
    exit /b 1
)

REM 检查Maven
mvn -version >nul 2>&1
if errorlevel 1 (
    echo Error: Maven is not installed or not in PATH
    echo Please install Maven 3.6 or higher
    pause
    exit /b 1
)

echo Building and starting server...
echo.

REM 编译并启动服务器
call mvn compile exec:java

if errorlevel 1 (
    echo Error: Failed to start server
    pause
) else (
    echo Server started successfully
    pause
)