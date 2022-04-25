package pl.Millionaires.Application.gui;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import pl.Millionaires.Application.model.Question;
import pl.Millionaires.Application.webclient.MillionairesClient;

import java.util.List;

@Route("/")
public class InitPane extends VerticalLayout{
    private Image mainImage = null;
    private Span questionText = null;
    private MillionairesClient millionairesClient = new MillionairesClient();
    private Button answer1 = null, answer2 = null, answer3 = null, answer4 = null, rememberLastClickedButton = null;
    private List<Question> questionsList = millionairesClient.getQuestionsList();
    private HorizontalLayout horizontalLayout = new HorizontalLayout();
    private VerticalLayout verticalLayout = new VerticalLayout();
    private static int indexCounter = 0, usedQuestionCounter = 0;

    public InitPane(){
        nextQuestion();
        add(verticalLayout, horizontalLayout);
    }
    private HorizontalLayout addButtons(Question question){
        answer1 = addButtonProperties(answer1, question);
        answer2 = addButtonProperties(answer2, question);
        answer3 = addButtonProperties(answer3, question);
        answer4 = addButtonProperties(answer4, question);

        horizontalLayout.add(answer1, answer2, answer3, answer4);
        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);

        return horizontalLayout;
    }
    private void buttonEvent(Button o, Question q) {
        Button tmp = o;
        if (o.equals(rememberLastClickedButton)) {
            if((q.getCorrectAnswer()).equals(o.getText().substring(3))) {

                o.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
                horizontalLayout.replace(tmp, o);

                Image oldImage = mainImage;
                mainImage = setImageSize("https://c.tenor.com/773Qu5kPwucAAAAM/good-answer-family-feud-canada.gif");
                verticalLayout.replace(oldImage, mainImage);

                Button nextQuestionButton = new Button( usedQuestionCounter + "/10 good answers. " + " Go to next question!");

                if (usedQuestionCounter >= 10)
                    nextQuestionButton.setText("10/10 good answers, You win!");
                nextQuestionButton.addClickListener(e -> nextQuestion());
                verticalLayout.add(nextQuestionButton);
            }
            else{
                o.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
                horizontalLayout.replace(tmp, o);
                Image oldImage = mainImage;
                mainImage = setImageSize("https://i.gifer.com/QeMS.gif");
                verticalLayout.replace(oldImage, mainImage);
            }
        }
        else {
            if (rememberLastClickedButton != null)
                rememberLastClickedButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
            o = new Button(tmp.getText());
            o.addClickListener(e -> buttonEvent(e.getSource(), q));
            horizontalLayout.replace(tmp, o);
            Image oldImage = mainImage;
            mainImage = setImageSize("https://c.tenor.com/WFys_BZKJEQAAAAC/is-that-your-final-answer-regis-phibin.gif");

            verticalLayout.replace(oldImage, mainImage);
        }

        rememberLastClickedButton = o;
    }
    private Button addButtonProperties(Button button, Question question){
        if (answer1 != null && answer1.equals(button))
            indexCounter = 0;
        Button tmp = new Button((char)(indexCounter + 65) +". " + question.getAllAnswers().get(indexCounter));
        tmp.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
        tmp.addClickListener(e -> buttonEvent(e.getSource(), question));
        indexCounter++;

        return tmp;
    }
    private void nextQuestion(){
        if (usedQuestionCounter >= 10){
            Image tmp = mainImage;
            mainImage = setImageSize("https://i.makeagif.com/media/10-13-2015/FymNEH.gif");
            verticalLayout.replace(tmp, mainImage);
        }
        else{
            if (usedQuestionCounter > 0){
                horizontalLayout.removeAll();
                verticalLayout.removeAll();
            }
            mainImage = setImageSize("https://static.wikia.nocookie.net/logopedia/images/d/d8/WWTBAM_Logo_2011.png");

            questionText = new Span(questionsList.get(usedQuestionCounter).getQuestion());
            questionText.getElement().getThemeList().add("badge success");
            questionText.setSizeFull();

            horizontalLayout = addButtons(questionsList.get(usedQuestionCounter++));
            verticalLayout.add(mainImage, questionText);
        }
    }
    private Image setImageSize(String src){
        Image tmp = new Image(src, "Unfortunately we can't display Icon :// ");
        tmp.setWidth(292, Unit.PIXELS);
        tmp.setHeight(292, Unit.PIXELS);
        return tmp;
    }
}
