package starter.stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;

public class WordCount {
    @Given("The actor navigates to the WordCounter page")
    public void theActorNavigatesToTheWordCounterPage() {
        System.out.println("corrió");
        throw new PendingException();
    }
}
