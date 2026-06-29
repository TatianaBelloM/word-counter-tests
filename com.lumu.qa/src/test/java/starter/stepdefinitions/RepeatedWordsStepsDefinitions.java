package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.screenplay.questions.KeywordDensityCount;
import starter.screenplay.questions.TopKeywordCount;
import starter.screenplay.questions.TopKeywordWord;


public class RepeatedWordsStepsDefinitions {

    @Then("the keyword density list should display {int} keywords")
    public void theKeywordDensityListShouldDisplay(int expectedCount) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(KeywordDensityCount.displayed()).isGreaterThanOrEqualTo(expectedCount)
        );
    }

    @Then("the top {int} keyword should be {string} with count {string}")
    public void theTopKeywordShouldBeWithCount(int position, String word, String count) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(TopKeywordWord.atPosition(position)).isEqualTo(word),
                Ensure.that(TopKeywordCount.atPosition(position)).isEqualTo(count)
        );
    }
}
