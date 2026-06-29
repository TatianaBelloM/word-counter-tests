package com.lumu.qa.stepdefinitions;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import com.lumu.qa.screenplay.questions.KeywordDensityCount;
import com.lumu.qa.screenplay.questions.TopKeywordCount;
import com.lumu.qa.screenplay.questions.TopKeywordWord;


public class RepeatedWordsStepsDefinitions {

    @Then("the keyword density list should display {int} keywords")
    public void theKeywordDensityListShouldDisplay(int expectedCount) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(KeywordDensityCount.displayed()).isGreaterThanOrEqualTo(expectedCount)
        );
    }

    @Then("the top {int} keyword should be {string} with count {int}")
    public void theTopKeywordShouldBeWithCount(int position, String word, int count) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(TopKeywordWord.atPosition(position)).isEqualTo(word),
                Ensure.that(TopKeywordCount.atPosition(position)).isEqualTo(count)
        );
    }
}
