package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.questions.GetTextQuestion;
import com.demoqa.automation.ui.TextBoxPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class TextBoxValidations implements Task {
    DataInjection dataInjection = new DataInjection();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(
                seeThat(GetTextQuestion.in(TextBoxPage.FULL_NAME_VALIDATION),equalToIgnoringCase(dataInjection.getExtensionName()+FillAllFields.name)),
                seeThat(GetTextQuestion.in(TextBoxPage.EMAIL_VALIDATION),equalToIgnoringCase(dataInjection.getExtensionEmail()+FillAllFields.email)),
                seeThat(GetTextQuestion.in(TextBoxPage.CURRENT_ADDRESS_VALIDATION),equalToIgnoringCase(dataInjection.getExtensionCurrentAddress()+FillAllFields.currentAddress)),
                seeThat(GetTextQuestion.in(TextBoxPage.PERMANENT_ADDRESS_VALIDATION),equalToIgnoringCase(dataInjection.getExtensionPermanentAddress()+FillAllFields.permanentAddress))
                );
    }

    public static TextBoxValidations compareText(){
        return instrumented(TextBoxValidations.class);
    }


}
