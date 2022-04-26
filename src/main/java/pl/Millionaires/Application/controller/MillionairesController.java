package pl.Millionaires.Application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import pl.Millionaires.Application.webclient.MillionairesClient;

public class MillionairesController {
    private MillionairesClient millionairesClient;

    @GetMapping("/question")
    public void showQuestion(){
        millionairesClient.getQuestion("easy");
    }
}
