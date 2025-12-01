package com.hxl.ai.controller;

import com.hxl.ai.function.CalculatorTools;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * 函数调用控制器
 * @author hengxiaoliang
 */
@RestController
public class FunctionCallController {

    @Resource
    private ChatClient functionClient;

    @Resource
    private CalculatorTools CalculatorTools;

    @GetMapping(value = "/chat", produces = "text/html;charset=UTF-8")
    public Flux<String> chat(@RequestParam("msg") String msg) {
        return functionClient.prompt()
                .user(msg)
                .tools(CalculatorTools) // 注册工具，使AI能够调用[citation:3][citation:7]
                .stream()
                .content();
    }
}
