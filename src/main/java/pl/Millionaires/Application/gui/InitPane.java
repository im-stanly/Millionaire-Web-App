package pl.Millionaires.Application.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ClickableRenderer;
import com.vaadin.flow.router.Route;
import pl.Millionaires.Application.model.Question;
import pl.Millionaires.Application.webclient.MillionairesClient;

import java.util.LinkedList;
import java.util.List;

@Route("/")
public class InitPane extends VerticalLayout{
    private Image mainImage;
    private Span questionText;
    private MillionairesClient millionairesClient = new MillionairesClient();
    private Button answer1, answer2, answer3, answer4, rememberLastClickedButton = null;
    private List<Button> listButtons = new LinkedList<>();
    private List<Question> questionsList = millionairesClient.getQuestionsList();

    public InitPane(){
        mainImage = new Image("https://static.wikia.nocookie.net/logopedia/images/d/d8/WWTBAM_Logo_2011.png", "Unfortunately we can't display Icon :// ");
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        add(mainImage);

        questionText = new Span(questionsList.get(0).getQuestion());
        questionText.getElement().getThemeList().add("badge success");
        questionText.setSizeFull();

        listButtons.add(answer1);
        listButtons.add(answer2);
        listButtons.add(answer3);
        listButtons.add(answer4);

        add(questionText);
        add(addButtons(questionsList.get(0)));
    }
    private HorizontalLayout addButtons(Question question){
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        answer1 = new Button("A.\t" + question.getAllAnswers().get(0));
        answer1.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
        answer1.addClickListener(e -> buttonEvent(e.getSource()));

        answer2 = new Button("B.\t" + question.getAllAnswers().get(1));
        answer2.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);

        answer3 = new Button("C.\t" + question.getAllAnswers().get(2));
        answer3.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);

        answer4 = new Button("D.\t" + question.getAllAnswers().get(3));
        answer4.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);

        horizontalLayout.add(answer1, answer2, answer3, answer4);
        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);

        return horizontalLayout;
    }
    public void buttonEvent(Button o) {
//        if (rememberLastClickedButton == o)
 //           mainImage = new Image("https://c.tenor.com/WFys_BZKJEQAAAAC/is-that-your-final-answer-regis-phibin.gif", "Unfortunately we can't display Icon :// ");
//
//        rememberLastClickedButton = o;
//        for (Button tmp: listButtons){
//            if (tmp != rememberLastClickedButton)
//                tmp.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
//        }
//
        o.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        System.out.println("tresc buttona to " + o.getText());
    }

}
