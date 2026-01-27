package net.saad.airagsystem.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AgentController {

    private ChatClient chatClient;
    public AgentController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build() ;
    }

    @GetMapping(value = "/Ask",produces = MediaType.TEXT_PLAIN_VALUE)
    public Flux<String> AskAgent(@RequestParam(defaultValue = "Hello") String query ){
        return this.chatClient.prompt().user(query).stream().content();

    }
}
