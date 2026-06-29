package starter.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TopKeywordCount implements Question<String> {

    private final int position;

    private TopKeywordCount(int position) {
        this.position = position;
    }

    public static Question<String> atPosition(int position) {
        return new TopKeywordCount(position);
    }

    @Override
    public String answeredBy(Actor actor) {
        Target count = Target.the("keyword count at position " + position)
                .locatedBy("#kwd-accordion-data a.list-group-item:nth-child(" + position + ") span.badge");
        actor.attemptsTo(WaitUntil.the(count, isVisible()).forNoMoreThan(10).seconds());
        return Text.of(count).answeredBy(actor).split(" ")[0];
    }
}
