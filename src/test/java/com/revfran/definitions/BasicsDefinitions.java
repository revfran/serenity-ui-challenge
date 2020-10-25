package com.revfran.definitions;

import com.revfran.navigation.NavigateTo;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import io.cucumber.java.Before;

public class BasicsDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{actor} opens adidas Finland home page")
    public void researchingThings(Actor actor) {
        actor.wasAbleTo(NavigateTo.theAdidasFinlandHomePage());
    }
}
