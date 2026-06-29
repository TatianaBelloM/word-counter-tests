package starter.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

public class StableCountPoller {

    public static Integer poll(Actor actor, Target target, long maxWaitMs) {
        long deadline = System.currentTimeMillis() + maxWaitMs;
        int previous = -1;
        while (System.currentTimeMillis() < deadline) {
            String raw = target.resolveFor(actor).getText().trim().replaceAll("[^0-9]", "");
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
