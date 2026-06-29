package com.lumu.qa.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import com.lumu.qa.screenplay.ui.WordCounterPage;

@Subject("keyword count at position #position")
public class TopKeywordCount implements Question<Integer> {

    private final int position;

    private TopKeywordCount(int position) {
        this.position = position;
    }

    public static Question<Integer> atPosition(int position) {
        return new TopKeywordCount(position);
    }

    @Override
    public Integer answeredBy(Actor actor) {
        String raw = Text.of(WordCounterPage.keywordCountAt(position)).answeredBy(actor).trim();
        return Integer.parseInt(raw.split("\\s+")[0]);
    }
}
