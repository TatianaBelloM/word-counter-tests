package com.lumu.qa.screenplay.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://wordcounter.net/")
public class WordCounterPage extends PageObject {

    public static final Target ITEM_BOX = Target.the("text input box").locatedBy("#box");

    public static final Target WORD_COUNT = Target.the("word count").locatedBy("#word_count");

    public static final Target CHARACTER_COUNT = Target.the("character count").locatedBy("#character_count");

    public static final Target KEYWORD_ITEMS = Target.the("keyword density items")
            .locatedBy("#kwd-accordion-data a.list-group-item");

    public static Target keywordWordAt(int position) {
        return Target.the("keyword word at position " + position)
                .locatedBy("#kwd-accordion-data a.list-group-item:nth-child(" + position + ") span.word");
    }

    public static Target keywordCountAt(int position) {
        return Target.the("keyword count at position " + position)
                .locatedBy("#kwd-accordion-data a.list-group-item:nth-child(" + position + ") span.badge");
    }
}
