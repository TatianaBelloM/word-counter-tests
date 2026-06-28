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

    // Palabras (Texto de la palabra)
    public static Target FIRST_KEYWORD_WORD = Target.the("first keyword word")
            .locatedBy("#kwd-accordion-data a.list-group-item:nth-child(1) span.word");

    public static Target SECOND_KEYWORD_WORD = Target.the("second keyword word")
            .locatedBy("#kwd-accordion-data a.list-group-item:nth-child(2) span.word");

    public static Target THIRD_KEYWORD_WORD = Target.the("third keyword word")
            .locatedBy("#kwd-accordion-data a.list-group-item:nth-child(3) span.word");

    // Conteos (Número de repeticiones)
    public static Target FIRST_KEYWORD_COUNT = Target.the("first keyword count")
            .locatedBy("#kwd-accordion-data a.list-group-item:nth-child(1) span.badge");

    public static Target SECOND_KEYWORD_COUNT = Target.the("second keyword count")
            .locatedBy("#kwd-accordion-data a.list-group-item:nth-child(2) span.badge");

    public static Target THIRD_KEYWORD_COUNT = Target.the("third keyword count")
            .locatedBy("#kwd-accordion-data a.list-group-item:nth-child(3) span.badge");

}
