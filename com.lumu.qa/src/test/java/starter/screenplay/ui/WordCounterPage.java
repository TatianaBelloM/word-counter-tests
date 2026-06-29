package starter.screenplay.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


@DefaultUrl("https://wordcounter.net/")
public class WordCounterPage extends PageObject {
    // Caja de texto
    public static Target ITEM_BOX = Target.the("item box").locatedBy("#box");

    // Contador de palabras
    public static Target WORD_COUNT = Target.the("item word count").locatedBy("#word_count");

    //Contador de caracteres
    public static Target CHARACTER_COUNT = Target.the("item character count").locatedBy("#character_count");

    // Tabla de densidad de palabras
    public static Target KEYWORD_DENSITY = Target.the("item Keyword density").locatedBy("#kwd-accordion-data");

}
