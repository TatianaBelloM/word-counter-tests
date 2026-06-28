package starter.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class KeywordDensityCount implements Question<Integer>{

    private static final Target KEYWORD_ITEMS = Target.the("keyword items")
            .locatedBy("#kwd-accordion-data a.list-group-item");

    public static Question<Integer> displayed() {
        return new KeywordDensityCount();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor)
                .findAll("#kwd-accordion-data a.list-group-item")
                .size();
    }
}
