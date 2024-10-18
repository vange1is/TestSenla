package hangman;

import java.util.Random;

public class WordGenerator {
    private static final String[] WORDS = {"planet", "guitar", "jungle", "butter", "holiday", "network", "fashion", "victory", "fantasy", "picture"};

    public String getRandomWord() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }
}