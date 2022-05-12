package com.nology;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class Startup {

    public static void main(String[] args) throws IOException {

        // create both implementations of QuestionLoader
        QuestionLoader basicLoader = new BasicQuestionLoader();
        QuestionLoader fileLoader = new CSVQuestionLoader("src/main/resources/questions.csv");
        ScoreCalculator calculator = new ScoreCalculator();

        // use the appropriate loader.
        GameCreator gameCreator = new GameCreator( basicLoader, calculator );

        System.out.println(FigletFont.convertOneLine("Nology Quiz!"));

        System.out.println("Welcome to the show... \n\n");
        System.out.println("Enter 'quit' or 'exit' to stop.\n");

        Controller controller = new Controller(gameCreator);
        controller.play();
    }

}
