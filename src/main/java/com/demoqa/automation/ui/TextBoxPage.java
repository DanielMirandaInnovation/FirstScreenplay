package com.demoqa.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TextBoxPage {
    public static String URL = "https://www.demoqa.com/text-box";
    public static final Target FULL_NAME_INPUT = Target.the("").located(By.id("userName"));
    public static final Target EMAIL_INPUT = Target.the("").located(By.id("userEmail"));
    public static final Target CURRENT_ADDRESS_INPUT = Target.the("").located(By.id("currentAddress"));
    public static final Target PERMANENT_ADDRESS_INPUT = Target.the("").located(By.id("permanentAddress"));
    public static final Target SUBMIT_BUTTON = Target.the("").located(By.id("submit"));
    public static final Target FULL_NAME_VALIDATION = Target.the("").located(By.id("name"));
    public static final Target EMAIL_VALIDATION = Target.the("").located(By.id("email"));
    public static final Target CURRENT_ADDRESS_VALIDATION = Target.the("").locatedBy("//p[@id='currentAddress']");
    public static final Target PERMANENT_ADDRESS_VALIDATION = Target.the("").locatedBy("//p[@id='permanentAddress']");

}
