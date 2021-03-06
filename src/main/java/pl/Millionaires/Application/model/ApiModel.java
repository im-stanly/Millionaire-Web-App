package pl.Millionaires.Application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiModel {
    private String category;
    private String difficulty;
    private String question;
    private String correct_answer;
    public List<String> incorrectAnswers = null;

}
