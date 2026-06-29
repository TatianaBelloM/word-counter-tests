package starter.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TopKeywordWord implements Question<String> {

    private final int position;

    private TopKeywordWord(int position) {
        this.position = position;
    }

    public static Question<String> atPosition(int position) {
        return new TopKeywordWord(position);
    }

    @Override
    public String answeredBy(Actor actor) {
        Target keyword = Target.the("keyword word at position " + position)
                .locatedBy("#kwd-accordion-data a.list-group-item:nth-child(" + position + ") span.word");
        actor.attemptsTo(WaitUntil.the(keyword, isVisible()).forNoMoreThan(10).seconds());
        return Text.of(keyword).answeredBy(actor);
    }
}