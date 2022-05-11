package com.nology;

import com.nology.annotations.Bug;

import java.time.Instant;
import java.util.Scanner;

/**
 * Controller class for playing the game.
 * Handles creating a new game, displaying questions, get answers and displaying the results.
 */
public class Controller {

    private GameCreator gameCreator;

    public Controller(GameCreator gameCreator) {
        this.gameCreator = gameCreator;
    }

    public void play() {

        // start new game
        QuizGame quizGame = gameCreator.create();

        quizGame.startGame();
        boolean quit = false;
        try {

            // for each question/round
            while( quizGame.hasAnotherRound() ) {

                QuizQuestion nextQuestion = quizGame.getNextRound();

                displayQuestion( nextQuestion, quizGame.getRound());

                // start timer
                long startTime = Instant.now().getEpochSecond();

                // read answer from user
                int answer = getAnswer( nextQuestion.getOptions().size() );

                if (answer < 0) {
                    System.out.println("So soon? Shame!");
                    quit = true;
                    break;
                }

                // stop timer and calculate response time
                long elapsedTime = Instant.now().getEpochSecond() - startTime;

                // mark answer depending on if it's correct and the time of response
                boolean correct = quizGame.markQuestion(nextQuestion, answer, (int) elapsedTime);

                // update the game's score.
                int lastScore = quizGame.getLastScore();
                int score = quizGame.getScore();

                displayResults(nextQuestion, correct, lastScore, score);

            }
        } finally {
            quizGame.finishGame();
        }

        // show results of quiz
        displayFinalResults(quizGame, quit);


    }

    /**
     * Display results of last round.
     *
     * @param nextQuestion
     * @param correct
     * @param lastScore
     * @param score
     */
    @Bug(descr = {
            "the score and total are in the wrong order"
    })
    private void displayResults(QuizQuestion nextQuestion, boolean correct, int lastScore, int score) {
        if( correct ) {
            if( nextQuestion.getAnswerExplanation() != null && ! nextQuestion.getAnswerExplanation().equals("") ) {
                System.out.println("CORRECT! - " + nextQuestion.getAnswerExplanation());
            } else {
                System.out.println("CORRECT!");
            }
        } else {
            System.out.println("WRONG!");
        }
        System.out.printf("Score: %d, total: %d\n\n", score, lastScore);
    }

    /**
     * Display the final results.
     * @param quizGame
     * @param quit
     */
    @Bug(descr = {
            "the score output uses the getLastScore() instead of getScore()",
            "there's a missing break statement, causing 4,5,6 to run into 7,8"
    })
    private void displayFinalResults(QuizGame quizGame, boolean quit) {
        System.out.printf("Final Score: %d\n", quizGame.getLastScore());
        System.out.printf("You got %d out of %d in %d seconds\n",
                quizGame.getCorrectAnswers(), quizGame.getNumberOfQuestions(), quizGame.getElapsedTimeSeconds());

        double perCorrect = (quizGame.getCorrectAnswers() / (double) quizGame.getNumberOfQuestions()) * 100;
        switch ( (int) perCorrect / 10 ) {
            case 0:
                // unicode conversions! See http://www.russellcottrell.com/greek/utilities/SurrogatePairCalculator.htm
                System.out.println("What??? \uD83D\uDCA7");
                break;
            case 1:
            case 2:
            case 3:
                System.out.println("Very poor indeed!");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("Not bad, average i'd say");
            case 7:
            case 8:
                System.out.println("Pretty good, not too shabby!");
                break;
            case 9:
                System.out.println("So so close!");
                break;
            case 10:
                System.out.println("What an absolute star!! \u2605 \u2605 ");
                break;
        }

        System.out.println("\nThank you for playing, it's been emotional.");

    }

    @Bug(descr = {
            "game can never be quit because check uses && instead of ||"
    })
    private int getAnswer(int range) {
        Scanner scanner = new Scanner(System.in);

        while( true ) {
            System.out.printf("Enter a answer [%d-%d]: \n", 1, range);
            String line =  scanner.nextLine().trim().toLowerCase();
            if (line.startsWith("quit") && line.startsWith("exit")) {
                return -1;
            }
            if( line.equals("") ) {
                continue;
            }
            try {
                int answer = Integer.valueOf(line);
                if( answer < 1 || answer > range ) {
                    System.out.printf("Try again, must be between %d and %d\n", 1,range);
                } else {
                    return answer;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    /**
     * Display the question and options for a given round.
     * @param quizQuestion
     * @param round
     */
    @Bug(descr = {
            "the optionCount variable is never incremented, meaning each option has the same number"
    })
    private void displayQuestion(QuizQuestion quizQuestion, int round) {

        System.out.printf("Question %s: %s\n", round, quizQuestion.getQuestion());
        int optionCount = 1;
        for (String option : quizQuestion.getOptions()) {
            System.out.printf(" %d - %s\n", optionCount, option);
        }

    }

}
