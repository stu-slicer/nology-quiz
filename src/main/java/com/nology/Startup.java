package com.nology;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class Startup {

    public static void main(String[] args) throws IOException {
        QuestionLoader loader = new BasicQuestionLoader();
        ScoreCalculator calculator = new ScoreCalculator();
        GameCreator gameCreator = new GameCreator( loader, calculator );

        System.out.println(FigletFont.convertOneLine("Nology Quiz!"));

        System.out.println("\nWelcome to the show... \n\n");

        Controller controller = new Controller(gameCreator);
        controller.play();
    }

}
