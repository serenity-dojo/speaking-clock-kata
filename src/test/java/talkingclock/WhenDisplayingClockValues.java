package talkingclock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WhenDisplayingClockValues {

    @ParameterizedTest
    @CsvSource(value =
            {
                    "1:one",
                    "2:two",
                    "3:three",
                    "4:four",
                    "5:five",
                    "6:six",
                    "7:seven",
                    "8:eight",
                    "9:nine",
            },
            delimiter = ':')
    void shouldDisplayAMinuteValueInTextForNumbersUpToTen(String minutes, String minutesAsText) {
        String actualMinutesAsText = SpokenTime.minutesAsTextFor(Integer.parseInt(minutes));
        assertThat(actualMinutesAsText).isEqualTo(minutesAsText);
    }

    @ParameterizedTest
    @CsvSource(value =
            {
                    "11:eleven",
                    "16:sixteen",
                    "19:nineteen",
            },
            delimiter = ':')
    void shouldDisplayAMinuteValueInTextForNumbersBetweenTenAndTwenty(String minutes, String minutesAsText) {
        String actualMinutesAsText = SpokenTime.minutesAsTextFor(Integer.parseInt(minutes));
        assertThat(actualMinutesAsText).isEqualTo(minutesAsText);
    }

    @ParameterizedTest
    @CsvSource(value =
            {
                    "20:twenty",
                    "21:twenty one",
                    "22:twenty two",
                    "29:twenty nine",
                    "35:thirty five",
                    "42:forty two",
                    "57:fifty seven",
            },
            delimiter = ':')
    void shouldDisplayAMinuteValueInTextForNumbersBetweenTwentyAndSixty(String minutes, String minutesAsText) {
        String actualMinutesAsText = SpokenTime.minutesAsTextFor(Integer.parseInt(minutes));
        assertThat(actualMinutesAsText).isEqualTo(minutesAsText);
    }

}
