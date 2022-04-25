package pl.Millionaires.Application.webclient;

import org.springframework.web.client.RestTemplate;
import pl.Millionaires.Application.model.ApiModel;
import pl.Millionaires.Application.model.Question;
import pl.Millionaires.Application.webclient.dto.MillionairesQuestionDto;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MillionairesClient {
    private static final String QUESTION_URL = "https://opentdb.com/api.php";
    private RestTemplate restTemplate = new RestTemplate();

    public ApiModel getQuestion(String difficulty){
        MillionairesQuestionDto apiModel = callGetMethod("?amount=2&difficulty={difficulty}&type=multiple",
                MillionairesQuestionDto.class,
                difficulty);

        return ApiModel.builder()
                .category(apiModel.getResults().get(0).category)
                .difficulty(apiModel.getResults().get(0).difficulty)
                .question(apiModel.getResults().get(0).question)
                .correct_answer(apiModel.getResults().get(0).correct_answer)
                .incorrectAnswers(apiModel.getResults().get(0).incorrect_answers)
                .build();
    }
    private List<Question> getPartQuestionsList(String difficulty, int numberOfQuestions){
        List<Question> oneDifficultyQuestionsList = new LinkedList<>();

        MillionairesQuestionDto apiModel = callGetMethod("?amount={numberOfQuestions}&difficulty={difficulty}&type=multiple",
                MillionairesQuestionDto.class,
                numberOfQuestions, difficulty);

        for (int i = 0; i < numberOfQuestions; i++){
            List<String> tmp = apiModel.getResults().get(i).incorrect_answers;
            tmp.add(new Random().nextInt(4), apiModel.getResults().get(i).correct_answer);

            oneDifficultyQuestionsList.add(new Question(
                apiModel.getResults().get(i).category,
                apiModel.getResults().get(i).difficulty,
                apiModel.getResults().get(i).question,
                apiModel.getResults().get(i).correct_answer,
                tmp // All answers
            ));
        }

        return oneDifficultyQuestionsList;
    }

    public List<Question> getQuestionsList(){
        List<Question> completeQuestionsList = getPartQuestionsList("easy", 4);
        completeQuestionsList.addAll(getPartQuestionsList("medium", 3));
        completeQuestionsList.addAll(getPartQuestionsList("hard", 3));

        return completeQuestionsList;
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object ... objects) {
        return restTemplate.getForObject(QUESTION_URL + url,
                responseType, objects);
    }
}
