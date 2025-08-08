@echo off
echo Running Drools Go Client Demo...
echo.

REM 检查Go版本
go version >nul 2>&1
if errorlevel 1 (
    echo Error: Go is not installed or not in PATH
    echo Please install Go 1.20 or higher
    pause
    exit /b 1
)

echo Installing dependencies...
echo.
call go mod tidy

if errorlevel 1 (
    echo Error: Failed to install dependencies
    pause
    exit /b 1
)

echo Starting Go client demo...
echo.
echo Make sure the Java server is running on localhost:50051
echo.

REM 运行客户端演示程序
call go run main.go

if errorlevel 1 (
    echo Error: Failed to run client
    pause
) else (
    echo Demo completed successfully
    pause
)