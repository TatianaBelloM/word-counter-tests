package com.lumu.qa.stepdefinitions;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import com.lumu.qa.screenplay.questions.CounterQuestion;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterStepsDefinitions {
    @Then("the character counter should display {int}")
    public void theCharacterCounterShouldDisplay(int expectCharacters) {
        Integer charactersFound = OnStage.theActorInTheSpotlight().asksFor(CounterQuestion.forCharacters());

        assertThat(charactersFound)
                .as("the character counter should show %d but it showed %d",expectCharacters,charactersFound)
                .isEqualTo(expectCharacters);
    }
}
