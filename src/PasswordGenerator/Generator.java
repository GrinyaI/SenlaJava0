package PasswordGenerator;

import java.security.SecureRandom;
import java.util.Scanner;

public class Generator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
    private final SecureRandom random;

    public Generator() {
        this.random = new SecureRandom();
    }

    private String shuffleString(String input) {
        char[] characters = input.toCharArray();

        for (int i = characters.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }

        return new String(characters);
    }

    public String generatePassword(int length) {
        if (length < 8 || length > 12) {
            throw new IllegalArgumentException("Длина пароля должна быть от 8 до 12 символов.");
        }

        StringBuilder passwordBuilder = new StringBuilder(length);

        passwordBuilder.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        passwordBuilder.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        passwordBuilder.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        passwordBuilder.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        for (int i = 4; i < length; i++) {
            passwordBuilder.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
        }

        return shuffleString(passwordBuilder.toString());
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Generator passwordGenerator = new Generator();

        int passwordLength;

        do {
            System.out.print("Введите длину пароля (от 8 до 12): ");
            passwordLength = scanner.nextInt();
        } while (passwordLength < 8 || passwordLength > 12);

        String password = passwordGenerator.generatePassword(passwordLength);
        System.out.println("Сгенерированный пароль: " + password);

        scanner.close();
    }
}