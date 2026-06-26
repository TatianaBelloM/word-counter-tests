package starter.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.screenplay.ui.WordCount;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@Subject("word count")
public class WordCountFound implements Question<Integer> {

    public static WordCountFound displayed(){
        return new WordCountFound();
    }

    @Override
    public Integer answeredBy(Actor actor){
        actor.attemptsTo(WaitUntil.the(WordCount.WORD_COUNT, isVisible())
                .forNoMoreThan(10).seconds()
        );
        return pollForStableValue(actor,3000);
    }

    private Integer pollForStableValue(Actor actor, long maxWaitMs) {
        long deadline = System.currentTimeMillis() + maxWaitMs;
        int previous = -1;
        while (System.currentTimeMillis() < deadline) {
            String raw = WordCount.WORD_COUNT
                    .resolveFor(actor).getText().trim().replaceAll("[^0-9]", "");
            int current = raw.isEmpty() ? 0 : Integer.parseInt(raw);
            if (current == previous && current >= 0) {
                return current;
            }
            previous = current;
            try { Thread.sleep(200); } catch (InterruptedException ignored) {}
        }
        return previous < 0 ? 0 : previous;
    }
}
