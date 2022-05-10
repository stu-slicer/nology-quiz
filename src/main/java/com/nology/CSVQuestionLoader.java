package com.nology;

import com.nology.annotations.Bug;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVQuestionLoader implements QuestionLoader {

    private String fileName;

    public CSVQuestionLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    @Bug(descr = {
            "the token for Genre is not converted to lowercase",
            "String option3 is set to tokens[5] - should be tokens[6]"
    })
    public List<QuizQuestion> loadQuestions() {

        List<QuizQuestion> questions = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            for (String line : lines) {
                // ignore comments
                if(  "".equals(line.trim()) || line.startsWith("#") ) {
                    continue;
                }
                try {
                    String[] tokens = line.trim().split(",");
                    Genre genre =  Genre.valueOf(tokens[0]);
                    String question = tokens[1];
                    QuestionLevel level = QuestionLevel.valueOf(tokens[2].toLowerCase());
                    String option0 = tokens[3];
                    String option1 = tokens[4];
                    String option2 = tokens[5];
                    String option3 = tokens[5];
                    int answer = Integer.parseInt(tokens[7]);
                    String additionalInfo = null;
                    if( tokens.length > 8 ) {
                        additionalInfo = tokens[8];
                    }

                    QuizQuestion quizQuestion = QuizQuestion.create(question, option0, option1, option2, option3, answer, level, genre, additionalInfo);
                    questions.add( quizQuestion );
                } catch (Exception e) {
                    // log exception and move on
                    System.out.println("Warning: Exception with line: " + line);
                    System.err.println(e);
                }
            }
        } catch (IOException e) {
            // wrap as an unchecked exception
            throw new RuntimeException(String.format("Exception attempting to load file %s", this.fileName), e);
        }

        return questions;
    }
}
