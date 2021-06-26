package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.ui.TextBoxPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillAllFields implements Task {

    DataInjection dataInjection = new DataInjection();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(dataInjection.getName()).into(TextBoxPage.FULL_NAME_INPUT),
                Enter.theValue(dataInjection.getEmail()).into(TextBoxPage.EMAIL_INPUT),
                Enter.theValue(dataInjection.getCurrentAddress()).into(TextBoxPage.CURRENT_ADDRESS_INPUT),
                Enter.theValue(dataInjection.getPermanentAddress()).into(TextBoxPage.PERMANENT_ADDRESS_INPUT),
                JavaScriptClick.on(TextBoxPage.SUBMIT_BUTTON),
                WaitUntil.the(TextBoxPage.FULL_NAME_VALIDATION,isVisible())
        );
    }

    public static FillAllFields successful(){
        return instrumented(FillAllFields.class);
    }



}
