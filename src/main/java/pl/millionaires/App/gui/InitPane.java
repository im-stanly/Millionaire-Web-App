package pl.millionaires.App.gui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import pl.millionaires.App.model.Question;
import pl.millionaires.App.webclient.MillionairesClient;

import java.util.List;


@Route("/")
public class InitPane extends VerticalLayout {

    public InitPane(){
        MillionairesClient tmp = new MillionairesClient();
        List<Question> nothing = tmp.getQuestionsList();

        System.out.println(nothing.get(0).getQuestion());

        add(new InitPaneHorizontal());
    }

}
