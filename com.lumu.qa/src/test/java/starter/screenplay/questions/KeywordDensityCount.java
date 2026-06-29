package starter.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class KeywordDensityCount implements Question<Integer>{

    private static final Target KEYWORD_ITEMS = Target.the("keyword items")
            .locatedBy("#kwd-accordion-data a.list-group-item");

    public static Question<Integer> displayed() {
        return new KeywordDensityCount();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(KEYWORD_ITEMS, isVisible()).forNoMoreThan(10).seconds());
        return KEYWORD_ITEMS.resolveAllFor(actor).size();
    }
}
