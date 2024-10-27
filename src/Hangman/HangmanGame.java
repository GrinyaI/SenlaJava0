package Hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {"кант", "фильтр", "скворечник", "процессор", "радиатор"};
    private static final int MAX_LIVES = 7;

    private static String getRandomWord() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }

    private static boolean updateGuessedWord(String wordToGuess, char[] guessedWord, char guessedLetter) {
        boolean isCorrect = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guessedLetter) {
                guessedWord[i] = guessedLetter;
                isCorrect = true;
            }
        }
        return isCorrect;
    }

    private static boolean isWordGuessed(char[] guessedWord) {
        for (char c : guessedWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    private static String drawHangman(int lives) {
        return switch (lives) {
            case 7 -> """
                    _______
                    |
                    |
                    |
                    |
                    """;
            case 6 -> """
                    _______
                    |    / \\
                    |    | |
                    |
                    |
                    """;
            case 5 -> """
                    _______
                    |    / \\
                    |    |O|
                    |
                    |
                    """;
            case 4 -> """
                    _______
                    |    / \\
                    |    |O|
                    |     |
                    |
                    """;
            case 3 -> """
                    _______
                    |    / \\
                    |    |O|
                    |    /|
                    |
                    """;
            case 2 -> """
                    _______
                    |    / \\
                    |    |O|
                    |    /|\\
                    |
                    """;
            case 1 -> """
                    _______
                    |    / \\
                    |    |O|
                    |    /|\\
                    |    /
                    """;
            case 0 -> """
                    _______
                    |    / \\
                    |    |O|
                    |    /|\\
                    |    / \\
                    """;
            default -> "";
        };
    }

    public static void Start() {
        String wordToGuess = getRandomWord();
        char[] guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int lives = MAX_LIVES;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в игру 'Виселица'!");

        while (lives > 0 && !isWordGuessed(guessedWord)) {
            System.out.print(drawHangman(lives));
            System.out.println("Загаданное слово: " + String.valueOf(guessedWord));
            System.out.println("Осталось жизней: " + lives);
            System.out.print("Введите букву: ");
            char guessedLetter = scanner.nextLine().charAt(0);

            if (!updateGuessedWord(wordToGuess, guessedWord, guessedLetter)) {
                lives--;
                System.out.println("Неправильно! Вы потеряли жизнь.");
            }
        }

        if (isWordGuessed(guessedWord)) {
            System.out.println("Поздравляем! Вы угадали слово: " + wordToGuess);
        } else {
            System.out.println(drawHangman(lives));
            System.out.println("Вы проиграли! Загаданное слово было: " + wordToGuess);
        }

        scanner.close();
    }
}

class Main {
    public static void main(String[] args) {
        HangmanGame.Start();
    }
}