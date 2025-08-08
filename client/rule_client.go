package client

import (
	"context"
	"fmt"
	"log"
	"time"

	"drools-demo/proto"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
)

// RuleEngineClient 规则引擎客户端
type RuleEngineClient struct {
	conn   *grpc.ClientConn
	client proto.RuleEngineServiceClient
}

// NewRuleEngineClient 创建新的规则引擎客户端
func NewRuleEngineClient(serverAddr string) (*RuleEngineClient, error) {
	conn, err := grpc.Dial(serverAddr, grpc.WithTransportCredentials(insecure.NewCredentials()))
	if err != nil {
		return nil, fmt.Errorf("failed to connect: %v", err)
	}

	client := proto.NewRuleEngineServiceClient(conn)
	return &RuleEngineClient{
		conn:   conn,
		client: client,
	}, nil
}

// Close 关闭连接
func (c *RuleEngineClient) Close() error {
	return c.conn.Close()
}

// ExecuteRule 执行单个规则
func (c *RuleEngineClient) ExecuteRule(sessionID string, facts map[string]string) (*proto.RuleResponse, error) {
	ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
	defer cancel()

	req := &proto.RuleRequest{
		SessionId: sessionID,
		Facts:     facts,
	}

	resp, err := c.client.ExecuteRule(ctx, req)
	if err != nil {
		return nil, fmt.Errorf("failed to execute rule: %v", err)
	}

	return resp, nil
}

// AddRule 添加新规则
func (c *RuleEngineClient) AddRule(ruleName, ruleContent string, priority int32) (*proto.AddRuleResponse, error) {
	ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
	defer cancel()

	rule := &proto.RuleDefinition{
		RuleName:    ruleName,
		RuleContent: ruleContent,
		Priority:    priority,
	}

	req := &proto.AddRuleRequest{
		Rule: rule,
	}

	resp, err := c.client.AddRule(ctx, req)
	if err != nil {
		return nil, fmt.Errorf("failed to add rule: %v", err)
	}

	return resp, nil
}

// ExecuteRules 批量执行规则
func (c *RuleEngineClient) ExecuteRules(rules []*proto.RuleRequest) error {
	ctx, cancel := context.WithTimeout(context.Background(), 10*time.Second)
	defer cancel()

	stream, err := c.client.ExecuteRules(ctx)
	if err != nil {
		return fmt.Errorf("failed to create stream: %v", err)
	}

	// 发送规则请求
	for _, rule := range rules {
		if err := stream.Send(rule); err != nil {
			return fmt.Errorf("failed to send rule: %v", err)
		}
	}

	// 关闭发送流
	if err := stream.CloseSend(); err != nil {
		return fmt.Errorf("failed to close send: %v", err)
	}

	// 接收响应
	for {
		resp, err := stream.Recv()
		if err != nil {
			if err.Error() == "EOF" {
				break
			}
			return fmt.Errorf("failed to receive response: %v", err)
		}
		
		log.Printf("Received response: success=%v, results=%v", resp.Success, resp.Results)
	}

	return nil
}