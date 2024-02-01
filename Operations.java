import java.util.ArrayList;

public class Operations {
    
    public static double performCalculations(ArrayList<Double> numbers, ArrayList<String> operations) {
        if (numbers.isEmpty()) {
            return 0;
        }

        double result = numbers.get(0);
        int operationIndex = 0;

        for (int i = 1; i < numbers.size(); i++) {
            double nextNumber = numbers.get(i);
            String operation = operations.get(operationIndex);

            switch (operation) {
                case "add":
                    result += nextNumber;
                    break;
                case "subtract":
                    result -= nextNumber;
                    break;
                case "multiply":
                    result *= nextNumber;
                    break;
                case "divide":
                    if (nextNumber == 0) {
                        throw new ArithmeticException("Cannot divide by zero");
                    }
                    result /= nextNumber;
                    break;
                
                default:
                    throw new IllegalArgumentException("Invalid operation: " + operation);
            }

            operationIndex++;
        }

        return result;
    }

    
}
