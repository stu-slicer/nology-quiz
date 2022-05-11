# Bugs in Quiz!

The following are bugs have been introduced.

1. In GameCreator.create() the forShuffling list is not actually used when selecting the number of questions. Therefore only the first 10 are ever selected.
2. In GameCreator.create() the list forShuffling list is shuffled, and not the selected questions, so not questions are ever shuffled.
3. In ScoreCalculator.calculateScore() the if statement check for 10 seconds or less should be seconds <= 10, rather than a <, a time of 10 seconds will fail through to the 15 seconds or less.
4. In ScoreCalculator.calculateScore() the case statement for 15 seconds or less is missing the last 'hard' entry, so if the hard is correct then will actually lose a point!
5. In CSVQuestionLoader.loadQuestions() String option3 = tokens[5] is incorrect, it should be tokens[6], this results in the last two options been the same option.
6. In CSVQuestionLoader.loadQuestions() the token for Genre is not converted to lowercase, causing issues when loading badly formatted lines.
7. In QuizGame.finishGame() the length of duration is returned in mills - between.toMillis(), rather than seconds - between.getSeconds().
8. In QuizGame.markQuestion() the call to quizQuestion.markQuestion(answer) should subtract 1 from answer, as comment aboue says.
9. In QuizGame.markQuestion() the score (total score) is set to last score every time, rather than last score added to it.
10. In QuizQuestion.create() - the answer on the QuizQuestion is never set - so every answer has a correct answer of 0. 
11. In Controller.getAnswer() the check for ending the game can never happen as it's a && rather than ||
12. In Controller.displayFinalResults() the score output uses the getLastScore() instead of getScore() - just showing the last score not the full score.
13. In Controller.displayFinalResults() there's a missing break statement, causing 4,5,6 to run into 7,8.
14. In Controller.displayQuestion() the optionCount variable is never incremented, meaning each option has the same number.
15. In Controller.displayResults() the score and total are in the wrong order.
