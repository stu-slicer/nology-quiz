package com.nology;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

/**
 * Represents an game of the quiz. Holds information like the questions, score, number of correct answers, time started and so on.
 */
public class QuizGame {

    /**
     * {@link QuizQuestion} for the current game.
     */
    private List<QuizQuestion> questions;
    /**
     * {@link ScoreCalculator} used to calculate the score.
     */
    private ScoreCalculator scoreCalculator;
    /**
     * Keeps track of the rounds, indicates the current round.
     * When displayed to client then 1 is added - so start at round 1.
     */
    private int round = 0;
    /**
     * Number of corrects answers so far.
     */
    private int correctAnswers = 0;
    /**
     * Total score for the game so far.
     */
    private int score;
    /**
     * Score for the last question asked.
     */
    private int lastScore;
    /**
     * Start time for the game.
     */
    private LocalTime startTime;
    /**
     * Finish time for the game.
     */
    private LocalTime finishTime;
    /**
     * Total elapsed time for the game, populated once game has finished.
     */
    private int elapsedTimeSeconds;

    public QuizGame(List<QuizQuestion> questions, ScoreCalculator scoreCalculator) {
        this.questions = questions;
        this.scoreCalculator = scoreCalculator;
    }

    public void startGame() {
        this.startTime = LocalTime.now();
    }

    public void finishGame() {
        this.finishTime = LocalTime.now();
        Duration between = Duration.between(this.startTime, this.finishTime);
        this.elapsedTimeSeconds = (int) between.toMillis();
    }

    /**
     * Returns true if there's another round to play, otherwise false.
     * @return true if there's another round to play, otherwise false.
     */
    public boolean hasAnotherRound() {
        return round < questions.size();
    }

    /**
     * Starts the next round and returns the {@link QuizQuestion} for the new round.
     * @return
     */
    public QuizQuestion getNextRound() {
        QuizQuestion nextRound = this.questions.get(round);
        round++;
        return nextRound;
    }

    /**
     * Marks the given question using the user's answer and their elapsed time.
     * @param quizQuestion
     * @param answer
     * @param timeElapsedSeconds
     * @return
     */
    public boolean markQuestion(QuizQuestion quizQuestion, int answer, int timeElapsedSeconds) {
        // don't forget to subtract one from answer
        boolean correct = quizQuestion.markQuestion(answer);
        if( correct )
            correctAnswers++;
        lastScore = scoreCalculator.calculateScore(correct, quizQuestion.getLevel(), timeElapsedSeconds);
        score = lastScore;
        return correct;
    }

    public int getNumberOfQuestions() {
        return this.questions.size();
    }

    /**
     * Gets the current round.
     * @return
     */
    public int getRound() {
        return round;
    }

    /**
     * Gets the score so far.
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets the score for the last round.
     * @return
     */
    public int getLastScore() {
        return lastScore;
    }

    /**
     * Gets number of questions answered correctly.
     * @return
     */
    public int getCorrectAnswers() {
        return correctAnswers;
    }

    /**
     * Total time for game, in seconds.
     * @return
     */
    public int getElapsedTimeSeconds() {
        return elapsedTimeSeconds;
    }

}
