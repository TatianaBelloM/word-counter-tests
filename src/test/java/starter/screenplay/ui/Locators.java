package starter.screenplay.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


@DefaultUrl("https://wordcounter.net/")
public class Locators extends PageObject {
    public static Target ITEM_BOX = Target.the("item box").locatedBy("#box");

    public static Target WORD_COUNT = Target.the("item word count").locatedBy("#word_count");

    public static Target CHARACTER_COUNT = Target.the("item character count").locatedBy("#character_count");
}
