package talkingclock.stepdefinitions;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import talkingclock.TalkingClock;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockStepDefinitions {

    @ParameterType("\\d\\d:\\d\\d:\\d\\d")
    public LocalTime time(String value) {
        return LocalTime.parse(value);
    }

    LocalTime currentTime;
    TalkingClock talkingClock = new TalkingClock();

    @Given("the time is {time}")
    public void theTimeIsTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }

    String spokenTime;

    @When("we ask the time")
    public void weAskTheTime() {
        spokenTime = talkingClock.sayTheTimeFor(currentTime);
    }

    @Then("the speaking clock should say {string}")
    public void theSpeakingClockShouldSay(String expectedSpokenTime) {
        assertThat(spokenTime).isEqualTo(expectedSpokenTime);
    }
}
