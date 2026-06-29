package com.lumu.qa.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import com.lumu.qa.screenplay.ui.WordCounterPage;

@Subject("the #description")
public class CounterQuestion implements Question<Integer> {

    private final Target target;
    private final String description;

    private CounterQuestion(Target target, String description) {
        this.target = target;
        this.description = description;
    }

    public static CounterQuestion forWords() {
        return new CounterQuestion(WordCounterPage.WORD_COUNT, "word count");
    }

    public static CounterQuestion forCharacters() {
        return new CounterQuestion(WordCounterPage.CHARACTER_COUNT, "character count");
    }

    @Override
    public Integer answeredBy(Actor actor) {
        String raw = Text.of(target).answeredBy(actor).trim().replaceAll("[^0-9]", "");
        return raw.isEmpty() ? 0 : Integer.parseInt(raw);
    }
}
