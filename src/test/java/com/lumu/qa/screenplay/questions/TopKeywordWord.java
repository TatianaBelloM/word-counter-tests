package com.lumu.qa.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import com.lumu.qa.screenplay.ui.WordCounterPage;

@Subject("keyword word at position #position")
public class TopKeywordWord implements Question<String> {

    private final int position;

    private TopKeywordWord(int position) {
        this.position = position;
    }

    public static Question<String> atPosition(int position) {
        return new TopKeywordWord(position);
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(WordCounterPage.keywordWordAt(position)).answeredBy(actor);
    }
}