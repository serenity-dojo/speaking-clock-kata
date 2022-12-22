Feature: Display the time

  We would like the text to be simple to read, so we will round the current time to the next full 5 minutes
  (Definitely more convenient for the user than rounding down...).
  We will use a 12-hour clock (e.g. 13:00 is "one").
  For this particular clock we will not use "AM" and "PM", just the time

  Scenario Outline: Displaying well known times
    Given the time is <time>
    When we ask the time
    Then the speaking clock should say "<spoken-time>"
    Examples: Midnight and noon should be displayed as words not numbers
      | time     | spoken-time |
      | 12:00:00 | Noon        |
      | 00:00:00 | Midnight    |
    Examples: Morning times
      | time     | spoken-time   |
      | 01:00:00 | one o'clock   |
      | 02:00:00 | two o'clock   |
      | 03:00:00 | three o'clock |
      | 04:00:00 | four o'clock  |
      | 05:00:00 | five o'clock  |
      | 06:00:00 | six o'clock   |
    Examples: Afternoon times
      | time     | spoken-time   |
      | 13:00:00 | one o'clock   |
      | 14:00:00 | two o'clock   |
      | 15:00:00 | three o'clock |
    Examples: Should display hours and minutes when minutes are not zero
      | time     | spoken-time      |
      | 01:20:00 | one twenty       |
      | 01:23:00 | one twenty three |
      | 01:34:00 | one thirty four  |
      | 01:45:00 | one forty five   |
      | 01:57:00 | one fifty seven  |
    Examples: Should display half past within 3 minutes of 30 minutes past
      | time     | spoken-time      |
      | 04:29:00 | half past four   |
      | 05:26:00 | five twenty six  |
      | 08:27:00 | half past eight  |
      | 08:33:00 | half past eight  |
      | 01:23:00 | one twenty three |
    Examples: Should round seconds to minutes
      | time     | spoken-time     |
      | 01:20:01 | one twenty      |
      | 04:20:30 | four twenty one |
      | 06:20:59 | six twenty one  |
