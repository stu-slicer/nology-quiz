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
+ For each round the player is shown the next question and the four options, they enter their answer and the question is marked.
+ If the player got the question correct then Correct is displayed, along with any answer explanation.
+ If the player got the question wrong then just Wrong is displayed.
+ The speed of the player's response is measured and this affects the scoring.
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