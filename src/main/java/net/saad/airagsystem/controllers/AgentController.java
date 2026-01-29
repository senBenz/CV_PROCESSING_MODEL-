package net.saad.airagsystem.controllers;

import lombok.Builder;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
//@CrossOrigin("*")
public class AgentController {

    private ChatClient chatClient;
    private String Score;


    public AgentController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build() ;

    }

    /*@GetMapping(value = "/Ask",produces = MediaType.TEXT_PLAIN_VALUE)
    public Flux<String> AskAgent(@RequestParam(defaultValue = "Hello") String query ){
        return this.chatClient.prompt().user(query).stream().content();

    }*/
       //     FOR EACH REQUEST :
    // Scoring Method will recieve :
    // - the  JobDescription
    // -CvData content  as Structured Data from the python microservice
    // the Agent will analyse the two parameters (CvData and JobDesciption ) and return a Score


    @GetMapping(value = "/CvScoring")
    public String CvScoring(Object CvData ,String JobDescription,int Score){
        return this.Score;
    }
}
