package com.nology;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        // #TODO - BUG - LEAVE THIS OUT - SO ALWAYS PICKS THE FIRST 10
        List<QuizQuestion> forShuffling = new ArrayList<>( loader.loadQuestions() );
        Collections.shuffle( forShuffling );

        forShuffling.stream()
                .limit(this.numQuestions)
                .forEach(question -> questions.add( question ));

        // TODO BUG!!
        Collections.shuffle( questions );

        QuizGame game = new QuizGame(questions, calculator);

        return game;
    }

}
