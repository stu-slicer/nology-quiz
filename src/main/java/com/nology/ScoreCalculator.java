package com.nology;

public class ScoreCalculator {

    public int calculateScore(boolean correct, QuestionLevel level, int seconds) {
        if( correct ) {
            if (seconds <= 5) {
                switch (level) {
                    case easy:
                        return 5;
                    case medium:
                        return 8;
                    case hard:
                        return 10;
                }

            } else if( seconds <= 10) {
                switch (level) {
                    case easy:
                        return 4;
                    case medium:
                        return 6;
                    case hard:
                        return 8;
                }

            } else if( seconds <= 15 ) {
                switch (level) {
                    case easy:
                        return 2;
                    case medium:
                        return 4;
                    case hard:
                        return 6;
                }

            } else {
                switch (level) {
                    case easy:
                        return 1;
                    case medium:
                        return 2;
                    case hard:
                        return 4;
                }
            }

        }
        return 0;
    }

}
