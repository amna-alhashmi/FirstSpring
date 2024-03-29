package com.codeline.firstSpringDemo.Slack;

import antlr.ASTFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.awt.*;

@Component
public class SlackClient {
    public String sendMessage(String text){

        return WebClient.create().post()
                .uri("")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SlackPayload(text))
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }
}
