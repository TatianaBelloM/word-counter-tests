package starter.stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import starter.screenplay.questions.CharacterCountFound;
import starter.screenplay.questions.WordCountFound;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterStepsDefinitions {
    @Then("the character counter should display {int}")
    public void theCharacterCounterShouldDisplay(int expectCharacters) {
        Integer charactersFound = OnStage.theActorInTheSpotlight().asksFor(CharacterCountFound.displayed());

        assertThat(charactersFound)
                .as("the word counter should show %d but it showed %d",expectCharacters,charactersFound)
                .isEqualTo(expectCharacters);
    }
}
