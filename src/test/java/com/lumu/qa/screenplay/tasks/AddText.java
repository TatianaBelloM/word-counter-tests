package com.lumu.qa.screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import com.lumu.qa.screenplay.config.Timeouts;
import com.lumu.qa.screenplay.ui.WordCounterPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddText {

    private AddText() {}

    public static Performable addText(String text) {
        return Task.where("{0} adds a text " + text,
                Clear.field(WordCounterPage.ITEM_BOX),
                Enter.theValue(text).into(WordCounterPage.ITEM_BOX),
                WaitUntil.the(WordCounterPage.WORD_COUNT, isVisible()).forNoMoreThan(Timeouts.ELEMENT_VISIBILITY_SECONDS).seconds()
        );
    }
}
