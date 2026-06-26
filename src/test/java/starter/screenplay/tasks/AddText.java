package starter.screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import starter.screenplay.ui.Locators;

public class AddText {

    public static Performable addText(String itemBox){
        return Task.where("{0} adds a text "+itemBox,
                Enter.theValue(itemBox)
                        .into(Locators.ITEM_BOX));
    }
}
