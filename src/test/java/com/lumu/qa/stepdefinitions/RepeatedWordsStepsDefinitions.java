package com.lumu.qa.stepdefinitions;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import com.lumu.qa.screenplay.config.Timeouts;
import com.lumu.qa.screenplay.questions.KeywordDensityCount;
import com.lumu.qa.screenplay.questions.TopKeywordCount;
import com.lumu.qa.screenplay.questions.TopKeywordWord;
import com.lumu.qa.screenplay.ui.WordCounterPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

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
                WaitUntil.the(WordCounterPage.keywordWordAt(position), isVisible())
                        .forNoMoreThan(Timeouts.ELEMENT_VISIBILITY_SECONDS).seconds(),
                Ensure.that(TopKeywordWord.atPosition(position)).isEqualTo(word),
                Ensure.that(TopKeywordCount.atPosition(position)).isEqualTo(count)
        );
    }
}
