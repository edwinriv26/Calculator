import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<>();
        ArrayList<String> operations = new ArrayList<>();
        List<String> validOperations = Arrays.asList("add", "subtract", "multiply", "divide", "power", "root", "percent", "fraction", "clear", "history", "undo");
        String lastInputType = ""; // Tracks the type of the last input (number or operation)
        boolean isCalculating = true;

        while (isCalculating) {
            System.out.println("---Calculator---");
            System.out.println("Instructions:");
            System.out.println("Enter numbers and operations in any sequence.");
            System.out.println("Available operations: add, subtract, multiply, divide, power, root, percent, fraction.");
            System.out.println("Type 'solve' to calculate the result.");
            System.out.println("Type 'clear' to reset the calculator.");
            System.out.println("Type 'history' to view past calculations.");
            System.out.println("Type 'undo' to undo the last entry.");
            System.out.println("----------------");

            // User Input 
            while (true) {
                System.out.print("Enter a number or an operation: ");
                if (input.hasNextDouble()) {
                    double number = input.nextDouble();
                    if (!"number".equals(lastInputType) || numbers.isEmpty()) {
                        numbers.add(number);
                    } else {
                        numbers.set(numbers.size() - 1, number); 
                    }
                    lastInputType = "number";
                } else {
                    String operationOrCommand = input.next().toLowerCase();
                    if (operationOrCommand.equalsIgnoreCase("solve")) {
                        double result = Operations.performCalculations(numbers, operations);
                        System.out.println("Result: " + result);
                        isCalculating = false; 
                        break;
                    } else if (validOperations.contains(operationOrCommand)) {
                        if (!"operation".equals(lastInputType) || operations.isEmpty()) {
                            operations.add(operationOrCommand);
                        } else {
                            operations.set(operations.size() - 1, operationOrCommand); 
                        }
                        lastInputType = "operation";
                    } else {
                        System.out.println("Incorrect value. Please enter a valid operation.");
                    }
                }
            }
        }
        input.close();
    }
    
} 
