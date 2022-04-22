package pl.millionaires.App.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.millionaires.App.model.ApiModel;
import pl.millionaires.App.service.MillionairesService;

@RestController
@RequiredArgsConstructor
public class MillionairesController {
    private final MillionairesService millionairesService;

//    @GetMapping("/")
//    public ApiModel getQuestion(){
//        return millionairesService.getQuestion();
//    }
}
