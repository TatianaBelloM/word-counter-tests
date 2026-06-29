package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import starter.screenplay.questions.CharacterCountFound;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterStepsDefinitions {
    @Then("the character counter should display {int}")
    public void theCharacterCounterShouldDisplay(int expectCharacters) {
        Integer charactersFound = OnStage.theActorInTheSpotlight().asksFor(CharacterCountFound.displayed());

        assertThat(charactersFound)
                .as("the character counter should show %d but it showed %d",expectCharacters,charactersFound)
                .isEqualTo(expectCharacters);
    }
}
