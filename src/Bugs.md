# Bugs in Quiz!

The following are bugs have been introduced.

In GameCreator.create() the forShuffling list is not actually used when selecting the number of questions. Therefore only the first 10 are ever selected.
In GameCreator.create() the list forShuffling list is shuffled, and not the selected questions, so not questions are ever shuffled.
In ScoreCalculator.calculateScore() the if statement check for 10 seconds or less should be seconds <= 10, rather than a <, a time of 10 seconds will fail through to the 15 seconds or less.
In ScoreCalculator.calculateScore() the case statement for 15 seconds or less is missing the last 'hard' entry, so if the hard is correct then will actually lose a point!
In CSVQuestionLoader.loadQuestions() String option3 = tokens[5] is incorrect, it should be tokens[6], this results in the last two options been the same option.
In CSVQuestionLoader.loadQuestions() the token for Genre is not converted to lowercase, causing issues when loading badly formatted lines.
In QuizGame.finishGame() the length of duration is returned in mills - between.toMillis(), rather than seconds - between.getSeconds().
In QuizGame.markQuestion() the call to quizQuestion.markQuestion(answer) should subtract 1 from answer, as comment aboue says.
-----In QuizGame.markQuestion() the check for a successful answer is commented out, meaning that every answer is marked as correct.
In QuizGame.markQuestion() the score (total score) is set to last score every time, rather than last score added to it.
-----In QuizQuestion.create() - the first one. in the List.of( ... ) - option0 and option1 are the wrong way around.
In QuizQuestion.create() - the answer on the QuizQuestion is never set - so every answer has a correct answer of 0. 
In Controller.getAnswer() the check for ending the game can never happen as it's a && rather than ||
-----In Controller.getAnswer() the check for the answer's range checks from 0 rather than 1, allowing an answer of 0 to be given. 
In Controller.displayFinalResults() the score output uses the getLastScore() instead of getScore() - just showing the last score not the full score.
In Controller.displayFinalResults() there's a missing break statement, causing 4,5,6 to run into 7,8.
In Controller.displayQuestion() the optionCount variable is never incremented, meaning each option has the same number.
In Controller.displayResults() the score and total are in the wrong order.
* 