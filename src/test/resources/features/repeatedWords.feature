Feature: Repeated Words
  As a WordCounter user,
  I want to see the most frequently repeated words in my text
  To analyze keyword density

  Background:
    Given Tatiana navigates to the WordCounter page

  Scenario Outline: Identify the three most frequently repeated words in a text
    When Tatiana types the text "<Text>"
    Then the keyword density list should display <KeywordQuantity> keywords
    Then the top 1 keyword should be "<first_word>" with count "<first_count>"
    Then the top 2 keyword should be "<second_word>" with count "<second_count>"
    Then the top 3 keyword should be "<third_word>" with count "<third_count>"

    Examples:
      | Text                                                                                                                                                             | KeywordQuantity | first_word | first_count | second_word | second_count | third_word | third_count |
      | cat dog cat fish cat dog bird                                                                                                                                    | 4               | cat        | 3           | dog         | 2            | fish       | 1           |
      | hola hola hola mundo test                                                                                                                                        | 3               | hola       | 3           | mundo       | 1            | test       | 1           |
      | Hoy ya es ayer y ayer ya es hoy, ya llegó el día, y hoy es hoy.                                                                                                  | 7               | hoy        | 4           | ya          | 3            | es         | 3           |
      | Tres tristes tigres comían trigo en tres tristes platos, sentados en un trigal. Sentados en un trigal, en tres tristes platos, comían trigo tres tristes tigres. | 10              | tres       | 4           | tristes     | 4            | en         | 4           |


  Scenario Outline: Identify which word is repeated most often in a text with two keywords
    When Tatiana types the text "<Text>"
    Then the keyword density list should display <KeywordQuantity> keywords
    Then the top 1 keyword should be "<first_word>" with count "<first_count>"
    Then the top 2 keyword should be "<second_word>" with count "<second_count>"

    Examples:
      | Text                 | KeywordQuantity | first_word | first_count | second_word | second_count |
      | cat dog cat dog  cat | 2               | cat        | 3           | dog         | 2            |
      | hola hola hola mundo | 2               | hola       | 3           | mundo       | 1            |

  Scenario Outline: Identify the words that are repeated most frequently in a text when the word is a number
    When Tatiana types the text "<number>"
    Then the top 1 keyword should be "<first_word>" with count "<first_count>"

    Examples:
      | number                                                                                                                                               | first_word | first_count |
      | Habia 123 personas, 123 amigos, 123 que son familia                                                                                                  | 123        | 3           |
      | 1 2 3 4 5 1 2 1                                                                                                                                      | 1          | 3           |
      | 3 tristes tigres comían trigo en 3 tristes platos, sentados en un trigal. Sentados en un trigal, en 3 tristes platos, comían trigo 3 tristes tigres. | 3          | 4           |

  Scenario: Identify the most frequently repeated word by mixing uppercase and lowercase letters.
    When Tatiana types the text "Hola hola HOLA"
    Then the top 1 keyword should be "hola" with count "3"

  Scenario Outline: Check keyword density when punctuation marks are present.
    When Tatiana types the text "<Text>"
    Then the top 1 keyword should be "<first_word>" with count "<first_count>"

    Examples:
      | Text                   | first_word | first_count |
      | hola, hola:hola; hola! | hola       | 4           |
      | hola? hola/hola hola.  | hola       | 4           |
      | hola hola ¡hola hola!  | hola       | 4           |
      | hola hola ¿hola hola?  | hola       | 4           |
      | hola hola [hola hola]  | hola       | 4           |
      | hola hola {hola hola}  | hola       | 4           |
      | hola hola <hola hola>  | hola       | 4           |
      | hola hola "hola hola"  | hola       | 4           |
      | hola hola 'hola hola'  | hola       | 4           |


