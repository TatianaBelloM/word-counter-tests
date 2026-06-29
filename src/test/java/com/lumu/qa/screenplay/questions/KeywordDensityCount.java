package com.lumu.qa.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import com.lumu.qa.screenplay.ui.WordCounterPage;

@Subject("keyword density count")
public class KeywordDensityCount implements Question<Integer> {

    public static Question<Integer> displayed() {
        return new KeywordDensityCount();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return WordCounterPage.KEYWORD_ITEMS.resolveAllFor(actor).size();
    }
}
