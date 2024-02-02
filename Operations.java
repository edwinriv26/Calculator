public class Operations {

    public static double performOperation(double firstNumber, double secondNumber, String operation) {
        switch (operation) {
            case "add":
                return firstNumber + secondNumber;
            case "subtract":
                return firstNumber - secondNumber;
            case "multiply":
                return firstNumber * secondNumber;
            case "divide":
                if (secondNumber == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return firstNumber / secondNumber;
            case "power":
                return Math.pow(firstNumber, secondNumber);
            case "root":
                if (secondNumber == 0) {
                    throw new ArithmeticException("Root degree cannot be zero");
                }
                return Math.pow(firstNumber, 1.0 / secondNumber);
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }

    public static boolean isValidOperation(String operation) {
        switch (operation) {
            case "add":
            case "subtract":
            case "multiply":
            case "divide":
            case "power":
            case "root":
                return true;
            default:
                return false;
        }
    }
}
