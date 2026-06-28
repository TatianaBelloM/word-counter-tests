package starter.screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import starter.screenplay.ui.WordCounterPage;

public class AddText {

    public static Performable addText(String itemBox){
        return Task.where("{0} adds a text "+itemBox,
                Clear.field(WordCounterPage.ITEM_BOX),
                Enter.theValue(itemBox)
                        .into(WordCounterPage.ITEM_BOX));
    }
}
