package com.nology;

import java.util.ArrayList;
import java.util.List;

public class BasicQuestionLoader implements QuestionLoader {

    private List<QuizQuestion> questions;

    public BasicQuestionLoader() {
        questions = load();
    }

    @Override
    public List<QuizQuestion> loadQuestions() {
        return List.copyOf( questions );
    }

    private List<QuizQuestion> load() {
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add( QuizQuestion.create("Who directed the film Alien (1979)?",
                "Ridley Scott", "Steven Speilberg", "John Carpenter", "Tony Scott",
                0, QuestionLevel.medium, Genre.film));
        questions.add( QuizQuestion.create("Which film is the odd one out?",
                "Castaway", "The Princess Nride", "The Road to Perdition", "The Terminal",
                1, QuestionLevel.medium, Genre.film,
                "The Princess Bride is the only film that doesn't star Tom Hanks."));
        questions.add( QuizQuestion.create("Who starred in the film Basic Instinct (1992)?",
                "Glenn Close", "Kim Basinger", "Sharon Stone", "Angela Raynor",
                2, QuestionLevel.medium, Genre.film));
        questions.add( QuizQuestion.create("Which is the best PIxar film of all time?",
                "Wall-e", "Toy Story", "The Incredibles", "Coco",
                3, QuestionLevel.easy, Genre.film, "It's a close call but it's Coco all day long. Fact."));
        questions.add( QuizQuestion.create("Which actor has been in every Pixar film?",
                "John Ratzenberger", "Tom Hanks", "Wallace Shawn", "John Lasseter",
                0, QuestionLevel.medium, Genre.film));
        questions.add( QuizQuestion.create("Which actor hasn't played Bond, James Bond?",
                "David Niven", "Sean Connery", "Timothy Dalton", "Christopher Lee",
                3, QuestionLevel.medium, Genre.film,
                "David Nivon played Sir James Bond in the spoof Casino Royale (1967)"));
        questions.add( QuizQuestion.create("Which film did Queen do the music for?",
                "The Neverending Story", "The Long Good Friday", "Highlander", "Baby Driver",
                2, QuestionLevel.medium, Genre.film ));
        questions.add( QuizQuestion.create("Which Batman film stars Michael Caine?",
                "Batman (1989)", "Batman Begins", "Batman and Robin", "The Batman (2022)",
                1, QuestionLevel.medium, Genre.film ));
        questions.add( QuizQuestion.create("Who directed Beetlejuice (1988)?",
                "Tim Robbins", "Joel Schumacher", "John Hughes", "Tim Burton",
                3, QuestionLevel.medium, Genre.film ));
        questions.add( QuizQuestion.create("Which actor isn't in Paddington 2 (2017)?",
                "Hugh Grant", "Matt Lucas", "Julie Walters", "Sanjeev Bhaskar",
                1, QuestionLevel.medium, Genre.film, "Matt Lucas was in the first Paddington" ));
        questions.add( QuizQuestion.create("Why is Ben Whishaw so great?",
                "Because he voices Paddington", "Because he plays Q in the Bond films", "Because he just is", "All of the above",
                3, QuestionLevel.medium, Genre.film));
        questions.add( QuizQuestion.create("Which ABBA song is not in Mamma Mia (2008)?",
                "SOS", "Super Trouper", "Does Your Mother Know?", "Fernando",
                3, QuestionLevel.medium, Genre.film));
        questions.add( QuizQuestion.create("Who directed the film Blue Velvet (1986)?",
                "David Fincher", "David Lynch", "David Cronenberg", "David Carradine",
                1, QuestionLevel.medium, Genre.film));
        questions.add( QuizQuestion.create("What film musical did Steven Speilberg remake in 2021?",
                "My Fair Lady", "Guys and Dolls", "West Side Story", "Oliver!",
                2, QuestionLevel.medium, Genre.film));
        questions.add( QuizQuestion.create("What was the mechanical shark nicknamed in Jaws (1975)?",
                "Bruce", "Boris", "Brian", "Barnaby",
                0, QuestionLevel.hard, Genre.film));
        questions.add( QuizQuestion.create("Who sang the song Bright Eyes in the film Watership Down (1978)?",
                "Art Garfunkel", "Paul Simon", "Mike Batt", "Barry Manilow",
                0, QuestionLevel.medium, Genre.film));
        questions.add( QuizQuestion.create("Who plays Agent Clarice Starling in The Silence of the Lambs (1991)?",
                "Gwyneth Paltrow", "Jodie Foster", "Julianne Moore", "Barry Manilow",
                1, QuestionLevel.medium, Genre.film));
        questions.add( QuizQuestion.create("What is not a Beatles film?",
                "Help!", "Yellow Submarine", "Sgt. Pepper's Lonely Hearts Club Band", "A Hard Day's Night",
                2, QuestionLevel.medium, Genre.film,
                "Sgt. Pepper's Lonely Hearts Club Band was made in the 70s with Peter Frampton and the BeeGees and all copies should be destroyed."));

        return questions;
    }

}
