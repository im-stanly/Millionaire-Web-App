package pl.Millionaires.Application.gui;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.renderer.ClickableRenderer;
import com.vaadin.flow.data.renderer.ClickableRenderer.ItemClickListener;
import pl.Millionaires.Application.model.Question;

public class InitPaneHorizontal extends HorizontalLayout {
    private Button answer1, answer2, answer3, answer4;

    public InitPaneHorizontal(Question question){

        answer1 = new Button("A.\t" + question.getAllAnswers().get(0));
        answer1.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);

        answer2 = new Button("B.\t" + question.getAllAnswers().get(1));
        answer2.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);

        add(answer1, answer2);
        InitRemainingButtons(question);
        setJustifyContentMode(JustifyContentMode.CENTER);
        getStyle().set("flex-wrap", "wrap");
        setJustifyContentMode(JustifyContentMode.END);
    }
    private void InitRemainingButtons(Question question){
        answer3 = new Button("C.\t" + question.getAllAnswers().get(2));
        answer3.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);

        answer4 = new Button("D.\t" + question.getAllAnswers().get(3));
        answer4.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);

        add(answer3, answer4);
    }
}
