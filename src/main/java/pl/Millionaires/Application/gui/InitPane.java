package pl.Millionaires.Application.gui;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import pl.Millionaires.Application.model.Question;
import pl.Millionaires.Application.webclient.MillionairesClient;

import java.util.List;

@Route("/")
public class InitPane extends VerticalLayout {

    public InitPane(){
        Span textField = new Span("Tresc pytania");

        MillionairesClient tmp = new MillionairesClient();

        List<Question> nothing = tmp.getQuestionsList();
        System.out.println(nothing.get(0).getQuestion());

        add(textField ,new InitPaneHorizontal());
    }
}
