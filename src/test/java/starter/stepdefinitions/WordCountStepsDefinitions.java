package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import starter.screenplay.questions.WordCountFound;
import starter.screenplay.tasks.AddText;
import starter.screenplay.tasks.NavigateTo;

import static org.assertj.core.api.Assertions.assertThat;

public class WordCountStepsDefinitions {
    @Given("{actor} navigates to the WordCounter page")
    public void ActorNavigatesToTheWordCounterPage(Actor actor) {
        actor.wasAbleTo(NavigateTo.openUrl());
    }

    @When("{actor} types the text {string}")
    public void theActorTypesTheText(Actor actor,String itemBox) {
        actor.attemptsTo(AddText.addText(itemBox));
    }

    @Then("the word counter should display {int}")
    public void theWordCounterShouldDisplay(int expectedWord) {
        Integer wordsFound = OnStage.theActorInTheSpotlight().asksFor(WordCountFound.displayed());

        assertThat(wordsFound)
                .as("the word counter should show %d but it showed %d",expectedWord,wordsFound)
                .isEqualTo(expectedWord);
    }
}
