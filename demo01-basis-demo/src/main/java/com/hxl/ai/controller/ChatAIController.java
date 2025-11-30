package com.hxl.ai.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatAIController {

    @Resource
    private OpenAiChatModel aiChatModel;

    @GetMapping("/chat")
    public String chat(String question) {
        return aiChatModel.call(question);
    }

}
