
package pl.millionaires.App.model.example;

import lombok.Getter;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
@Getter
public class Result {

    public String category;

    public String type;

    public String difficulty;

    public String question;

    public String correct_answer;

    public List<String> incorrect_answers = null;
}
