package com.nology;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Responsible for creating a new {@link QuizGame}.
 */
public class GameCreator {

    private QuestionLoader loader;
    private ScoreCalculator calculator;
    /**
     * Number of {@link QuizQuestion}s per game.
     */
    private int numQuestions = 10;

    public GameCreator(QuestionLoader loader, ScoreCalculator calculator) {
        this.loader = loader;
        this.calculator = calculator;
    }

    public QuizGame create() {

        // select the questions
        List<QuizQuestion> questions = new ArrayList<>();

        List<QuizQuestion> forShuffling = new ArrayList<>( loader.loadQuestions() );
        Collections.shuffle( forShuffling );

        forShuffling.stream()
                .limit(this.numQuestions)
                .forEach(question -> questions.add( question ));

        Collections.shuffle( questions );

        QuizGame game = new QuizGame(questions, calculator);

        return game;
    }

}
