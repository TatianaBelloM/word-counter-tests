package com.lumu.qa.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import com.lumu.qa.screenplay.questions.CounterQuestion;
import com.lumu.qa.screenplay.tasks.AddText;
import com.lumu.qa.screenplay.tasks.NavigateTo;

import static org.assertj.core.api.Assertions.assertThat;

public class WordCountStepsDefinitions {
    @Given("{actor} navigates to the WordCounter page")
    public void actorNavigatesToTheWordCounterPage(Actor actor) {
        actor.wasAbleTo(NavigateTo.openUrl());
    }

    @When("{actor} types the text {string}")
    public void theActorTypesTheText(Actor actor, String text) {
        actor.attemptsTo(AddText.addText(text.replace("\\n", "\n")));
    }

    @Then("the word counter should display {int}")
    public void theWordCounterShouldDisplay(int expectedWord) {
        Integer wordsFound = OnStage.theActorInTheSpotlight().asksFor(CounterQuestion.forWords());

        assertThat(wordsFound)
                .as("the word counter should show %d but it showed %d", expectedWord, wordsFound)
                .isEqualTo(expectedWord);
    }
}
