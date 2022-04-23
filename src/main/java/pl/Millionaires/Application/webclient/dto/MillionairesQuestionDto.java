package pl.Millionaires.Application.webclient.dto;

import lombok.Getter;
import pl.Millionaires.Application.model.example.Result;

import java.util.List;

@Getter
public class MillionairesQuestionDto {
    public int response_code;

    public List<Result> results = null;
}
