package hangman;

import java.util.Scanner;

public class Hangman {
    private static final int MAX_LIVES = 6;
    private String wordToGuess;
    private boolean[] guessedLetters;
    private int lives;

    public Hangman() {
        WordGenerator wordGenerator = new WordGenerator();
        this.wordToGuess = wordGenerator.getRandomWord();
        this.guessedLetters = new boolean[wordToGuess.length()];
        this.lives = MAX_LIVES;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру Виселица!");

        while (lives > 0 && !isWordGuessed()) {
            System.out.println("\n" + getDisplayWord());
            System.out.println("Осталось жизней: " + lives);
            printHangman();

            System.out.print("Введите букву: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (!processGuess(guess)) {
                lives--;
            }
        }

        if (isWordGuessed()) {
            System.out.println("\nПоздравляем! Вы угадали слово: " + wordToGuess);
        } else {
            System.out.println("\nВы проиграли. Загаданное слово было: " + wordToGuess);
            printHangman();
        }

        scanner.close();
    }

    private boolean processGuess(char guess) {
        boolean isCorrectGuess = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess && !guessedLetters[i]) {
                guessedLetters[i] = true;
                isCorrectGuess = true;
            }
        }

        if (!isCorrectGuess) {
            System.out.println("Буквы " + guess + " нет в слове.");
        }

        return isCorrectGuess;
    }

    private String getDisplayWord() {
        StringBuilder displayWord = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (guessedLetters[i]) {
                displayWord.append(wordToGuess.charAt(i)).append(" ");
            } else {
                displayWord.append("# ");
            }
        }
        return displayWord.toString();
    }

    private boolean isWordGuessed() {
        for (boolean guessed : guessedLetters) {
            if (!guessed) {
                return false;
            }
        }
        return true;
    }

    private void printHangman() {
        switch (lives) {
            case 6:
                System.out.println(" +---+");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("    ===");
                break;
            case 5:
                System.out.println(" +---+");
                System.out.println(" O   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("    ===");
                break;
            case 4:
                System.out.println(" +---+");
                System.out.println(" O   |");
                System.out.println(" |   |");
                System.out.println("     |");
                System.out.println("    ===");
                break;
            case 3:
                System.out.println(" +---+");
                System.out.println(" O   |");
                System.out.println("/|   |");
                System.out.println("     |");
                System.out.println("    ===");
                break;
            case 2:
                System.out.println(" +---+");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("     |");
                System.out.println("    ===");
                break;
            case 1:
                System.out.println(" +---+");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("/    |");
                System.out.println("    ===");
                break;
            case 0:
                System.out.println(" +---+");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("/ \\  |");
                System.out.println("    ===");
                break;
        }
    }
}
