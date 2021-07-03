package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.questions.GetTextQuestion;
import com.demoqa.automation.ui.TextBoxPage;
import com.demoqa.automation.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.io.IOException;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class ExcelValidations implements Task {

    DataInjection dataInjection = new DataInjection();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.should(
                    seeThat(GetTextQuestion.in(TextBoxPage.FULL_NAME_VALIDATION),equalToIgnoringCase(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getValidationsSheetName(),0,0))),
                    seeThat(GetTextQuestion.in(TextBoxPage.EMAIL_VALIDATION),equalToIgnoringCase(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getValidationsSheetName(),0,1))),
                    seeThat(GetTextQuestion.in(TextBoxPage.CURRENT_ADDRESS_VALIDATION),equalToIgnoringCase(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getValidationsSheetName(),0,2))),
                    seeThat(GetTextQuestion.in(TextBoxPage.PERMANENT_ADDRESS_VALIDATION),equalToIgnoringCase(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getValidationsSheetName(),0,3)))
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ExcelValidations compareText(){
        return instrumented(ExcelValidations.class);
    }

}
