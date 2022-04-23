package pl.Millionaires.Application.model.example;

import lombok.Getter;

import java.util.List;
import javax.annotation.Generated;

@Getter
@Generated("jsonschema2pojo")
public class Result {

    public String category;

    public String type;

    public String difficulty;

    public String question;

    public String correct_answer;

    public List<String> incorrect_answers = null;
}

