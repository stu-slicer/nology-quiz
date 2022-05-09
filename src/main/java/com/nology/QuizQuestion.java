package com.nology;

import java.util.List;
import java.util.Objects;

public class QuizQuestion {

    private String question;
    private List<String> options;
    private int answer;
    private String answerExplanation;
    private QuestionLevel level;
    private Genre genre;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getAnswerExplanation() {
        return answerExplanation;
    }

    public void setAnswerExplanation(String answerExplanation) {
        this.answerExplanation = answerExplanation;
    }

    public QuestionLevel getLevel() {
        return level;
    }

    public void setLevel(QuestionLevel level) {
        this.level = level;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean markQuestion(int answer) {
        return this.answer == answer;
    }

    /**
     * Create with everything apart from answer explanation.
     * @param question
     * @param option0
     * @param option1
     * @param option2
     * @param option3
     * @param answer
     * @param level
     * @param genre
     * @return
     */
    public static QuizQuestion create(String question, String option0, String option1, String option2, String option3, int answer, QuestionLevel level, Genre genre) {
        Objects.requireNonNull(option0);
        Objects.requireNonNull(option1);
        Objects.requireNonNull(option2);
        Objects.requireNonNull(option3);
        QuizQuestion quest = new QuizQuestion();
        quest.setQuestion(question);
        quest.setOptions( List.of( option0, option1, option2, option3) );
        quest.setAnswer(answer);
        quest.setLevel(level);
        quest.setGenre(genre);
        return quest;
    }

    public static QuizQuestion create(String question, String option0, String option1, String option2, int answer, QuestionLevel level, Genre genre) {
        Objects.requireNonNull(option0);
        Objects.requireNonNull(option1);
        Objects.requireNonNull(option2);
        QuizQuestion quest = new QuizQuestion();
        quest.setQuestion(question);
        quest.setOptions( List.of( option0, option1, option2) );
        quest.setAnswer(answer);
        quest.setLevel(level);
        quest.setGenre(genre);
        return quest;
    }

    public static QuizQuestion create(String question, String option0, String option1, int answer, QuestionLevel level, Genre genre) {
        Objects.requireNonNull(option0);
        Objects.requireNonNull(option1);
        QuizQuestion quest = new QuizQuestion();
        quest.setQuestion(question);
        quest.setOptions( List.of( option0, option1) );
        quest.setAnswer(answer);
        quest.setLevel(level);
        quest.setGenre(genre);
        return quest;
    }

    /**
     * Create with everything.
     * @param question
     * @param option0
     * @param option1
     * @param option2
     * @param option3
     * @param answer
     * @param level
     * @param genre
     * @return
     */
    public static QuizQuestion create(String question, String option0, String option1, String option2, String option3, int answer,
                                      QuestionLevel level, Genre genre, String explanation) {
        Objects.requireNonNull(option0);
        Objects.requireNonNull(option1);
        Objects.requireNonNull(option2);
        Objects.requireNonNull(option3);
        QuizQuestion quest = new QuizQuestion();
        quest.setQuestion(question);
        quest.setOptions( List.of( option0, option1, option2, option3) );
        quest.setAnswer(answer);
        quest.setLevel(level);
        quest.setGenre(genre);
        quest.setAnswerExplanation(explanation);
        return quest;
    }

    public static QuizQuestion create(String question, String option0, String option1, String option2, int answer,
                                      QuestionLevel level, Genre genre, String explanation) {
        Objects.requireNonNull(option0);
        Objects.requireNonNull(option1);
        Objects.requireNonNull(option2);
        QuizQuestion quest = new QuizQuestion();
        quest.setQuestion(question);
        quest.setOptions( List.of( option0, option1, option2) );
        quest.setAnswer(answer);
        quest.setLevel(level);
        quest.setGenre(genre);
        quest.setAnswerExplanation(explanation);
        return quest;
    }

    public static QuizQuestion create(String question, String option0, String option1, int answer,
                                      QuestionLevel level, Genre genre, String explanation) {
        Objects.requireNonNull(option0);
        Objects.requireNonNull(option1);
        QuizQuestion quest = new QuizQuestion();
        quest.setQuestion(question);
        quest.setOptions( List.of( option0, option1) );
        quest.setAnswer(answer);
        quest.setLevel(level);
        quest.setGenre(genre);
        quest.setAnswerExplanation(explanation);
        return quest;
    }

}
