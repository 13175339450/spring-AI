
package com.hxl.ai.function;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

/**
 * 计算工具
 * @author hengxiaoliang
 */
@Component // 注册为Spring Bean
public class CalculatorTools {

    @Tool(description = "对两个整数进行加法运算。例如，计算 5 加 3。")
    public int add(
            @ToolParam(description = "第一个加数") int a,
            @ToolParam(description = "第二个加数") int b) {
        System.out.println(">>> 工具被调用: 计算 " + a + " + " + b);
        return a + b;
    }

    @Tool(description = "对两个整数进行减法运算。例如，计算 10 减 4。")
    public int subtract(
            @ToolParam(description = "被减数") int a,
            @ToolParam(description = "减数") int b) {
        System.out.println(">>> 工具被调用: 计算 " + a + " - " + b);
        return a - b;
    }
}