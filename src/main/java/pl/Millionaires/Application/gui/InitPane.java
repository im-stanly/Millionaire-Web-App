package pl.Millionaires.Application.gui;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import pl.Millionaires.Application.model.Question;
import pl.Millionaires.Application.webclient.MillionairesClient;

import java.util.List;

@Route("/")
public class InitPane extends VerticalLayout{
    private Image mainImage;
    private Span questionText;
    private MillionairesClient millionairesClient = new MillionairesClient();
    private Button answer1 = null, answer2 = null, answer3 = null, answer4 = null, rememberLastClickedButton = null;
    private List<Question> questionsList = millionairesClient.getQuestionsList();
    private HorizontalLayout horizontalLayout = new HorizontalLayout();
    private VerticalLayout verticalLayout = new VerticalLayout();
    private static int counter = 0;

    public InitPane(){
        mainImage = new Image("https://static.wikia.nocookie.net/logopedia/images/d/d8/WWTBAM_Logo_2011.png", "Unfortunately we can't display Icon :// ");
        mainImage.setWidth(292, Unit.PIXELS);
        mainImage.setHeight(292, Unit.PIXELS);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        questionText = new Span(questionsList.get(0).getQuestion());
        questionText.getElement().getThemeList().add("badge success");
        questionText.setSizeFull();

        verticalLayout.add(mainImage, questionText);
        add(verticalLayout, addButtons(questionsList.get(0)));
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
    public void buttonEvent(Button o, Question q) {
        Button tmp = o;
        if (o.equals(rememberLastClickedButton)) {
            if((q.getCorrectAnswer()).equals(o.getText().substring(3))) {
                o.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
                horizontalLayout.replace(tmp, o);
            }
            else{
                o.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
                horizontalLayout.replace(tmp, o);
                Image oldImage = mainImage;
                mainImage = new Image("https://i.gifer.com/QeMS.gif", "Unfortunately we can't display Icon :// ");
                mainImage.setWidth(292, Unit.PIXELS);
                mainImage.setHeight(292, Unit.PIXELS);
                verticalLayout.replace(oldImage, mainImage);
            }
        }
        else {
            o.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            horizontalLayout.replace(tmp, o);
            Image oldImage = mainImage;
            mainImage = new Image("https://c.tenor.com/WFys_BZKJEQAAAAC/is-that-your-final-answer-regis-phibin.gif", "Unfortunately we can't display Icon :// ");
            mainImage.setWidth(292, Unit.PIXELS);
            mainImage.setHeight(292, Unit.PIXELS);
            verticalLayout.replace(oldImage, mainImage);
        }

        rememberLastClickedButton = o;
    }
    private Button addButtonProperties(Button button, Question question){
        if (answer1 != null && answer1.equals(button))
            counter = 0;
        Button tmp = new Button((char)(counter + 65) +". " + question.getAllAnswers().get(counter));
        tmp.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
        tmp.addClickListener(e -> buttonEvent(e.getSource(), question));
        counter++;

        return tmp;
    }

}
