# Nology Quiz

## Intro

A simple quiz with a number of multiple choice questions. The player answers 10 questions and receives a score
at the end of the game. The player's response is also timed. and the faster their response the higher the score.  

## Features

+ The quiz game consists of 10 questions.
+ All questions are multiple choice with up to 4 options and have a genre or category, for example film. There is also 
an optional answer explanation which can offer more details about the answer.
+ A question has a difficulty - easy, medium and hard - the level can affect the score - the harder the question the
higher the score.
+ For each round the player is shown a question and the four options, they enter their answer and the question is marked.
+ If the player got the question correct then Correct is displayed, along with any answer explanation.
+ If the player got the question wrong then just Wrong is displayed.
+ The speed of the player's response is measured and this affects the scoring.
+ The player can quit the game at any time by entering 'quit' or 'exit'.
+ At the end of the game the player's score is displayed and the time taken.
+ The score per question depends upon the level of difficulty and the speed of response from the player.

| Elapsed time               | Easy | Medium | Hard |
|----------------------------| ---- | ----- | ----- |
| 5 seconds or less          | 5 | 8 | 10 |
| 10 seconds or less         | 4 | 6 | 8 |
| 15 seconds or less         | 2 | 4 | 6 |
| more than 15 seconds       | 1 | 2 | 4 |

+ Questions can be loaded from a simple CSV file, with the format:

`genre, question, level, option0, option1, option2, option3, answer, answerExplanation`

+ For example:

`film,Who directed the film Alien (1979)?,medium,Ridley Scott,Steven Speilberg,John Carpenter,Tony Scott,0,`

+ There is also a set of hardcoded questions, which are loaded via `basicQuestionLoader`.


## Known problems

These are some of the problems discovered whilst attempting to play the game, there could be more.

1. When a question is displayed the options are all numbered 1, making it difficult to choose the right answer.
2. There are more than 10 questions in the file/basic loader however it always displays the same 10 questions.
3. You should be able to finish the game by typing 'quit' or 'exit', however this is ignored.
4. Sometimes the last two options are identical, not sure why.
5. The questions always appear in the same order, they should change on every run.
6. The time the game takes appears to be way to high, it's supposed to be seconds.
7. Some of the answer's don't appear to be correct, for example Tim Burton definitely directed Beetlejuice.
8. The total score doesn't appear to be increasing as you play.
9. Something is not quite right with the scoring for hard questions, especially if the user's response is around the 15 second mark - appear to lose a point!
10. There are various warning messages when loading questions from the CSV file, something dodgy is going on.
11. Not sure if the total score and last score are showing correctly.
12. If the player does average they get two comments - "Not bad, average i'd say" and "Pretty good, not too shabby!" - doesn't feel right.
