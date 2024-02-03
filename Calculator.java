//Edwin Rivera Calculator

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static List<String> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("--- Welcome to the Calculator ---");
        System.out.println("Instructions:");
        System.out.println("1. Enter numbers and choose operations to perform calculations.");
        System.out.println("2. At any point, type 'clear' to start over or 'exit' to quit the calculator.");
        System.out.println("3. Type 'history' to view past calculations.");
        System.out.println("---------------------------------");

        double firstNumber = getNumber(input, "Enter a number (or type 'clear' or 'exit'): ");

        while (true) {
            double secondNumber = getNumber(input, "Enter another number (or type 'clear' or 'exit'): ");
            String operation = getOperation(input);

            if ("clear".equalsIgnoreCase(operation)) {
                firstNumber = getNumber(input, "Enter a number (or type 'clear' or 'exit'): ");
                continue; // Start over
            }

            try {
                double result = Operations.performOperation(firstNumber, secondNumber, operation);
                System.out.println("Result: " + result);
                history.add(firstNumber + " " + operation + " " + secondNumber + " = " + result);
                firstNumber = result; // Use result as first number for next operation
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println(e.getMessage());
                firstNumber = getNumber(input, "Enter a number (or type 'clear' or 'exit'): "); // Reset after error
                continue;
            }

            String choice = getContinueChoice(input);
            if ("exit".equalsIgnoreCase(choice)) {
                input.close();
                return; // Exit program
            } else if ("clear".equalsIgnoreCase(choice)) {
                firstNumber = getNumber(input, "Enter a number (or type 'clear' or 'exit'): "); // Reset with new number
            } else if ("history".equalsIgnoreCase(choice)) {
                printHistory();
            }
            // If 'yes', continue with next calculation using the result as firstNumber
        }
    }

    private static String getContinueChoice(Scanner input) {
        while (true) {
            System.out.print("Continue with another operation on this result? (Type 'yes', 'history', 'clear', 'exit'): ");
            String choice = input.next();
            if (List.of("yes", "history", "clear", "exit").contains(choice.toLowerCase())) {
                return choice;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }

    private static void printHistory() {
        if (history.isEmpty()) {
            System.out.println("No history available.");
        } else {
            System.out.println("Calculation History:");
            for (String record : history) {
                System.out.println(record);
            }
        }
    }

    private static double getNumber(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (input.hasNextDouble()) {
                return input.nextDouble();
            } else {
                String command = input.next();
                if ("clear".equalsIgnoreCase(command)) {
                    return getNumber(input, "Enter a number (or type 'clear' or 'exit'): "); // Start over
                } else if ("exit".equalsIgnoreCase(command)) {
                    input.close();
                    System.exit(0);
                } else {
                    System.out.println("Invalid input. Please enter a number, 'clear', or 'exit'.");
                }
            }
        }
    }

    private static String getOperation(Scanner input) {
        while (true) {
            System.out.print("Enter an operation (add, subtract, multiply, divide, power, root) or 'clear' to start over: ");
            String operation = input.next().toLowerCase();
            if (Operations.isValidOperation(operation)) {
                return operation;
            } else if ("clear".equalsIgnoreCase(operation)) {
                return operation; // Handle 'clear' in the main loop
            } else if ("exit".equalsIgnoreCase(operation)) {
                input.close();
                System.exit(0); // Exit program
            } else {
                System.out.println("Invalid operation. Please try again, or type 'clear' to start over, or 'exit' to quit.");
            }
        }
    }
}
