package starter.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.screenplay.ui.WordCounterPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@Subject("character count")
public class CharacterCountFound implements Question<Integer> {
    public static CharacterCountFound displayed(){
        return new CharacterCountFound();
    }

    @Override
    public Integer answeredBy(Actor actor){
        actor.attemptsTo(WaitUntil.the(WordCounterPage.CHARACTER_COUNT, isVisible())
                .forNoMoreThan(10).seconds()
        );
        return StableCountPoller.poll(actor, WordCounterPage.CHARACTER_COUNT, 3000);
    }
}
