Feature: Word Count
  As a WordCounter user
  I want to count the words in a text
  To verify the exact number of words

  Background:
    Given Tatiana navigates to the WordCounter page

  Scenario Outline: Count words in a text
    When Tatiana types the text "<text>"
    Then the word counter should display <Quantity>

    Examples:
      | text                                                                  | Quantity |
      | hola mundo esto es una prueba                                         | 6        |
      | Estoy escribiendo un libro y estoy haciendo una prueba de esta pagina | 12       |
      | HolaHolaHola hola                                                     | 2        |
      | Hola, esta es una prueba.                                             | 5        |
      | hola 123 mundo                                                        | 3        |
      | hola   mundo                                                          | 2        |
      | well-known es algo                                                    | 3        |
      | it's a test                                                           | 3        |
      | hola                                                                  | 1        |
      | <hola>                                                                | 1        |
      | \"hola\"                                                              | 1        |

  Scenario Outline: Count words only with special characters
    When Tatiana types the text "<texto>"
    Then the word counter should display 0

    Examples:
      | texto      |
      | !#$%&/()=? |
      | []*        |
      | ;.!#       |
      | ¡          |
      | ¿          |

  Scenario: Count words with only spaces
    When Tatiana types the text "   "
    Then the word counter should display 0

  Scenario Outline: Count words only with numbers
    When Tatiana types the text "<numbers>"
    Then the word counter should display <quantity>

    Examples:
      | numbers                                          | quantity |
      | 12343                                            | 1        |
      | 1232                                             | 1        |
      | 1232789234098780342509872435 1239810398123809123 | 2        |

  Scenario: Count words separated by a line break
    When Tatiana types the text "hola\nmundo"
    Then the word counter should display 2

