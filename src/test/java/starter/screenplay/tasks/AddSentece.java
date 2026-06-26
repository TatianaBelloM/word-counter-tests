package starter.screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import starter.screenplay.ui.WordCount;

public class AddSentece {

    public static Performable simpleSentence(String itemBox){
        return Task.where("{0} adds a simple sentence "+itemBox,
                Enter.theValue(itemBox)
                        .into(WordCount.ITEM_BOX));
    }
}
