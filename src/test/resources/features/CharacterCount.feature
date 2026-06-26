Feature: Character Count
  As a WordCounter user,
  I want to count the characters in a text.
  To verify the exact length of the text.

  Background:
    Given Tatiana navigates to the WordCounter page

  Scenario Outline: Counting characters in a simple text
    When Tatiana types the text "<texto>"
    Then the character counter should display <cantidad>

    Examples:
      | texto              | cantidad |
      | parangutirimicuaro | 18       |
      | hola               | 4        |
      | Murcielago         | 10       |


  Scenario Outline: Counting characters including spaces
    When Tatiana types the text "<texto>"
    Then the character counter should display <cantidad>

    Examples:
      | texto                                                                                                                                                                                   | cantidad |
      | Hola mundo esto es una prueba                                                                                                                                                           | 29       |
      | Apart from counting words and characters, our online editor can help you to improve word choice and writing style, and, optionally, help you to detect grammar mistakes and plagiarism. | 183      |

