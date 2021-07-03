package com.demoqa.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class GetTextQuestion implements Question<String> {
    private Target target;

    public GetTextQuestion(Target target){
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).getText().trim();
    }

    public static GetTextQuestion in (Target target){
        return new GetTextQuestion(target);
    }

}
