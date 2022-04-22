package pl.millionaires.App.webclient.dto;

import lombok.Getter;
import pl.millionaires.App.model.example.Example;
import pl.millionaires.App.model.example.Result;

import java.util.List;

@Getter
public class MillionairesQuestionQuestionDto {
    public int response_code;

    public List<Result> results = null;
}
