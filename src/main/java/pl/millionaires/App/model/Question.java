package pl.millionaires.App.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Question {
    private String category;
    private String difficulty;
    private String question;
    private String correctAnswer;
    public List<String> allAnswers = null;
}
