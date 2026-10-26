package com.springai.olama.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class Codellama {

private Codellama codellama;

//chat client set
    private final ChatClient chatClient;

    //initialized by builder
    public Codellama(ChatClient.Builder builder){
       this.chatClient= builder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(required = true, value = "q") String query){
        String responsecontent = chatClient.prompt(query).call().content();
        return ResponseEntity.ok(responsecontent);
    }

}
