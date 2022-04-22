package pl.millionaires.App.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import pl.millionaires.App.model.Question;

public class InitPaneHorizontal extends HorizontalLayout {
    public InitPaneHorizontal(Question question){
        Button main = new Button(question.getQuestion());

        add(main);

        Button tmp1 = new Button(question.getAllAnswers().get(1));
        Button tmp2 = new Button(question.getAllAnswers().get(2));

        add(tmp1, tmp2);

        Button tmp3 = new Button(question.getAllAnswers().get(3));
        Button tmp4 = new Button(question.getAllAnswers().get(4));

        add(tmp3, tmp4);
    }
    public InitPaneHorizontal(){
        Span span = new Span("Question text");
        add(span);

        Button tmp = new Button(" bbbbb");
        tmp.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
        add(tmp);
    }
}
