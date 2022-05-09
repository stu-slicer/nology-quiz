package com.nology;

import java.util.List;

/**
 * Loads a list of {@link QuizQuestion}s from a suitable source.
 */
public interface QuestionLoader {

    List<QuizQuestion> loadQuestions();

}
