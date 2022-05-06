package com.nology;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuizGame {

    /**
     * {@link QuizQuestion} for the current game.
     */
    private List<QuizQuestion> questions;
    /**
     * Keeps track of the rounds, indicates the current round.
     * When displayed to client then 1 is added - so start at round 1.
     */
    private int round = 0;
    private int correctAnswers = 0;
    private int score;
    private int lastScore;
    private LocalTime startTime;
    private LocalTime finishTime;
    private int elapsedTimeSeconds;
    private ScoreCalculator scoreCalculator;

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
        this.elapsedTimeSeconds = (int) between.getSeconds();
    }

    public boolean hasAnotherRound() {
        return round < questions.size();
    }

    public QuizQuestion getNextRound() {
        QuizQuestion nextRound = this.questions.get(round);
        round++;
        return nextRound;
    }

    public boolean markQuestion(QuizQuestion quizQuestion, int answer, int timeElapsedSeconds) {
        // don't forget to subtract one from answer
        boolean correct = quizQuestion.getAnswer() == answer - 1; // TODO BUG
        if( correct ) {
            correctAnswers++;
        }
        lastScore = scoreCalculator.calculateScore(correct, quizQuestion.getLevel(), timeElapsedSeconds);
        score += lastScore;
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

    public int getScore() {
        return score;
    }

    public int getLastScore() {
        return lastScore;
    }

    /**
     * Get number of questions answered correctly.
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
