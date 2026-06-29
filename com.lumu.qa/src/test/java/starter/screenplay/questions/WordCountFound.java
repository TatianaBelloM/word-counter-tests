package starter.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.screenplay.ui.WordCounterPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@Subject("word count")
public class WordCountFound implements Question<Integer> {

    public static WordCountFound displayed(){
        return new WordCountFound();
    }

    @Override
    public Integer answeredBy(Actor actor){
        actor.attemptsTo(WaitUntil.the(WordCounterPage.WORD_COUNT, isVisible())
                .forNoMoreThan(10).seconds()
        );
        return StableCountPoller.poll(actor, WordCounterPage.WORD_COUNT, 3000);
    }
}
