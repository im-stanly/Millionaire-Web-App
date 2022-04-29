package pl.Millionaires.Application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.Millionaires.Application.model.ApiModel;
import pl.Millionaires.Application.webclient.MillionairesClient;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MillionairesService {
    private final MillionairesClient millionairesClient;

    public List<ApiModel> getQuestion(){
        List<ApiModel> listQuestions = new LinkedList<>();

        for (int i = 0; i < 4; i++)
            listQuestions.add(millionairesClient.getQuestion("easy"));
        for (int i = 0; i < 3; i++)
            listQuestions.add(millionairesClient.getQuestion("medium"));
        for (int i = 0; i < 3; i++)
            listQuestions.add(millionairesClient.getQuestion("hard"));

        return listQuestions;
    }
}
