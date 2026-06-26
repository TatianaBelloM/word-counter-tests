Feature: Word Count
  As a WordCounter user
  I want to count the words in a text
  To verify the exact number of words

  Background:
    Given Tatiana navigates to the WordCounter page

  Scenario Outline: Count words in a simple text
    When Tatiana types the text "<texto>"
    Then the word counter should display <cantidad>

    Examples:
      | texto                                                                 | cantidad |
      | hola mundo esto es una prueba                                         | 6        |
      | Estoy escribiendo un libro y estoy haciendo una prueba de esta pagina | 12       |
      | HolaHolaHola hola                                                     | 2        |
      | Hola, esta es una prueba.                                             | 5        |


  Scenario Outline: Count words only with special characters
    When Tatiana types the text "<texto>"
    Then the word counter should display 0

    Examples:
      | texto       |
      | !#$%&/()=?  |
      | []*         |
      | ;.!#        |
      | ¡           |
      | "           |


  Scenario: Count words with spaces
    When Tatiana types the text "   "
    Then the word counter should display 0

  Scenario Outline: Count words only with numbers
    When Tatiana types the text "<numbers>"
    Then the word counter should display 0

    Examples:
      | numbers |
      | 12343   |
      | 1232;   |

