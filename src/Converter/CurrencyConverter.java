package Converter;

import java.util.Scanner;

public class CurrencyConverter {
    private static final double RUB_TO_USD = 0.0103;
    private static final double RUB_TO_KZT = 5.029;
    private static final double RUB_TO_EUR = 0.0095;
    private static final double RUB_TO_GBP = 0.008;
    private static final double RUB_TO_JPY = 1.5661;

    private static double convertToUSD(double amount) {
        return amount * RUB_TO_USD;
    }

    private static double convertToKZT(double amount) {
        return amount * RUB_TO_KZT;
    }

    private static double convertToEUR(double amount) {
        return amount * RUB_TO_EUR;
    }

    private static double convertToGBP(double amount) {
        return amount * RUB_TO_GBP;
    }

    private static double convertToJPY(double amount) {
        return amount * RUB_TO_JPY;
    }

    public static void Convert(double amountInRUB) {
        System.out.println("Конвертация суммы " + amountInRUB + " RUB:");
        System.out.printf("В американских долларах (USD): %.2f%n", convertToUSD(amountInRUB));
        System.out.printf("В казахских тенге (KZT): %.2f%n", convertToKZT(amountInRUB));
        System.out.printf("В евро (EUR): %.2f%n", convertToEUR(amountInRUB));
        System.out.printf("В британских фунтах (GBP): %.2f%n", convertToGBP(amountInRUB));
        System.out.printf("В японских иенах (JPY): %.2f%n", convertToJPY(amountInRUB));
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму в рублях (RUB): ");
        double amountInRUB = scanner.nextDouble();

        CurrencyConverter.Convert(amountInRUB);

        scanner.close();
    }
}