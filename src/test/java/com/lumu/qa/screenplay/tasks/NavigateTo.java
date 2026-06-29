package com.lumu.qa.screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import com.lumu.qa.screenplay.ui.WordCounterPage;

public class NavigateTo {
    public static Performable openUrl(){
        return Task.where("{0} opens the Word Count page",
                Open.browserOn().the(WordCounterPage.class));
    }
}
