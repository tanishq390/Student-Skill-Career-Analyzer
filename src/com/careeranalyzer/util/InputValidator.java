package com.careeranalyzer.util;

import java.util.Scanner;

public class InputValidator {

    private Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getString(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty."
            );
        }
    }

    public double getDouble(
            String message,
            double min,
            double max) {

        while (true) {

            try {

                System.out.print(message);

                double value =
                        Double.parseDouble(
                                scanner.nextLine()
                        );

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println(
                        "Enter a value between "
                                + min + " and " + max
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid number. Try again."
                );
            }
        }
    }

    public int getInt(
            String message,
            int min,
            int max) {

        while (true) {

            try {

                System.out.print(message);

                int value =
                        Integer.parseInt(
                                scanner.nextLine()
                        );

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println(
                        "Enter a value between "
                                + min + " and " + max
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid integer. Try again."
                );
            }
        }
    }
}