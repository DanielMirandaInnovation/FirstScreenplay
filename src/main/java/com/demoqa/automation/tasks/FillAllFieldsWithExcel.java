package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.ui.TextBoxPage;
import com.demoqa.automation.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import java.io.IOException;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillAllFieldsWithExcel implements Task {

    DataInjection dataInjection = new DataInjection();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                   Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,0)).into(TextBoxPage.FULL_NAME_INPUT),
                    Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,1)).into(TextBoxPage.EMAIL_INPUT),
                   Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,2)).into(TextBoxPage.CURRENT_ADDRESS_INPUT),
                     Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,3)).into(TextBoxPage.PERMANENT_ADDRESS_INPUT),
                    JavaScriptClick.on(TextBoxPage.SUBMIT_BUTTON)
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FillAllFieldsWithExcel dataInjectionSheet(){
        return instrumented(FillAllFieldsWithExcel.class);
    }
}
