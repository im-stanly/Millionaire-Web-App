package pl.Millionaires.Application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.Millionaires.Application.model.ApiModel;
import pl.Millionaires.Application.service.MillionairesService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MillionairesController {
    private final MillionairesService millionairesService;

    @GetMapping("/questions")
    public List<ApiModel> getQuestion(){
        return millionairesService.getQuestion();
    }
}
