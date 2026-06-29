Feature: Character Count
  As a WordCounter user,
  I want to count the characters in a text.
  To verify the exact length of the text.

  Background:
    Given Tatiana navigates to the WordCounter page

  Scenario Outline: Counting characters in a simple text
    When Tatiana types the text "<text>"
    Then the character counter should display <cantidad>

    Examples:
      | text               | cantidad |
      | parangutirimicuaro | 18       |
      | hola               | 4        |
      | Murcielago         | 10       |


  Scenario Outline: Counting characters including spaces
    When Tatiana types the text "<text>"
    Then the character counter should display <cantidad>

    Examples:
      | text                                                                                                                                                                                    | cantidad |
      | Hola mundo esto es una prueba                                                                                                                                                           | 29       |
      | Apart from counting words and characters, our online editor can help you to improve word choice and writing style, and, optionally, help you to detect grammar mistakes and plagiarism. | 183      |

  Scenario Outline: Counting characters with only numbers
    When Tatiana types the text "<numbers>"
    Then the character counter should display <cantidad>

    Examples:
      | numbers               | cantidad |
      | 12345                 | 5        |
      | 12345678900987654321  | 20       |
      | 1234567890 0987654321 | 21       |

  Scenario: Count characters with spaces
    When Tatiana types the text "   "
    Then the character counter should display 3

  Scenario: Count character with only one character
    When Tatiana types the text "a"
    Then the character counter should display 1

  Scenario: Count character separated by a line break
    When Tatiana types the text "hola\nmundo"
    Then the character counter should display 10

  Scenario Outline: Counting characters with only special characters
    When Tatiana types the text "<special characters>"
    Then the character counter should display <cantidad>

    Examples:
      | special characters | cantidad |
      | !#$%$&             | 6        |
      | /()=?¡*[_:];:      | 13       |
      | ;:_;:-,.-          | 9        |