package main

import (
	"drools-demo/client"
	"fmt"
	"log"
)

func main() {
	// 连接到规则引擎服务器
	fmt.Println("Drools规则引擎Go语言Demo")
	fmt.Println("正在连接到规则引擎服务器...")
	
	ruleClient, err := client.NewRuleEngineClient("localhost:50051")
	if err != nil {
		log.Fatalf("连接失败: %v", err)
	}
	defer ruleClient.Close()

	// 演示1: 执行VIP折扣规则
	fmt.Println("\n=== 演示1: VIP折扣规则 ===")
	facts1 := map[string]string{
		"amount":       "1500",
		"customerType": "VIP",
		"product":      "笔记本电脑",
	}
	
	resp1, err := ruleClient.ExecuteRule("session-1", facts1)
	if err != nil {
		log.Printf("执行规则失败: %v", err)
	} else {
		fmt.Printf("规则执行结果: %v\n", resp1.Success)
		fmt.Printf("折扣结果: %v\n", resp1.Results)
		fmt.Printf("消息: %v\n", resp1.Messages)
	}

	// 演示2: 执行运费规则
	fmt.Println("\n=== 演示2: 运费规则 ===")
	facts2 := map[string]string{
		"weight":  "15",
		"product": "家具",
		"zone":    "国内",
	}
	
	resp2, err := ruleClient.ExecuteRule("session-2", facts2)
	if err != nil {
		log.Printf("执行规则失败: %v", err)
	} else {
		fmt.Printf("规则执行结果: %v\n", resp2.Success)
		fmt.Printf("运费结果: %v\n", resp2.Results)
		fmt.Printf("消息: %v\n", resp2.Messages)
	}

	// 演示3: 非VIP客户测试
	fmt.Println("\n=== 演示3: 普通客户折扣规则 ===")
	facts3 := map[string]string{
		"amount":       "1500",
		"customerType": "普通",
		"product":      "笔记本电脑",
	}
	
	resp3, err := ruleClient.ExecuteRule("session-3", facts3)
	if err != nil {
		log.Printf("执行规则失败: %v", err)
	} else {
		fmt.Printf("规则执行结果: %v\n", resp3.Success)
		fmt.Printf("折扣结果: %v\n", resp3.Results)
		fmt.Printf("消息: %v\n", resp3.Messages)
	}

	// 演示4: 添加新规则
	fmt.Println("\n=== 演示4: 添加新规则 ===")
	newRule := `
		rule "NewCustomerRule"
		when
		    Map( $isNew : this["isNewCustomer"] )
		    eval( Boolean.parseBoolean($isNew.toString()) )
		then
		    Map results = new HashMap();
		    results.put("welcomeGift", "true");
		    results.put("message", "新客户赠送礼品");
		    insert(results);
		end
	`
	
	addResp, err := ruleClient.AddRule("新客户规则", newRule, 2)
	if err != nil {
		log.Printf("添加规则失败: %v", err)
	} else {
		fmt.Printf("添加规则结果: %v\n", addResp.Success)
		fmt.Printf("消息: %v\n", addResp.Message)
	}

	// 演示5: 使用新规则
	fmt.Println("\n=== 演示5: 使用新客户规则 ===")
	facts5 := map[string]string{
		"isNewCustomer": "true",
		"customerName":  "张三",
	}
	
	resp5, err := ruleClient.ExecuteRule("session-5", facts5)
	if err != nil {
		log.Printf("执行规则失败: %v", err)
	} else {
		fmt.Printf("规则执行结果: %v\n", resp5.Success)
		fmt.Printf("新客户结果: %v\n", resp5.Results)
		fmt.Printf("消息: %v\n", resp5.Messages)
	}

	fmt.Println("\n=== Demo完成 ===")
	fmt.Println("按任意键退出...")
	fmt.Scanln()
}