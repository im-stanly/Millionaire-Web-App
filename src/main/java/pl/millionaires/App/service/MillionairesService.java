package pl.millionaires.App.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.millionaires.App.model.ApiModel;
import pl.millionaires.App.webclient.MillionairesClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class MillionairesService {
    private final MillionairesClient millionairesClient;

    public ApiModel getQuestion(){
        return millionairesClient.getQuestion("easy");
    }
}
