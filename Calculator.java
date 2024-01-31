import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Calculator {
    
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<>();
        ArrayList<String> operationlist = new ArrayList<>();
        boolean isCalculating = true;
        
        while (isCalculating) {
            // Prompts 
            System.out.println("---Calculator---");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Division");
            System.out.println("5. Power X");
            System.out.println("6. Root");
            System.out.println("7. Percent");
            System.out.println("8. Fraction");
            System.out.println("9. Undo");
            System.out.println("10. Clear");
            System.out.println("11. History");
            System.out.println("----------------");
            
            
                //User Input 
                while (true) {
                    System.out.print("Enter a number: ");
                    while (!input.hasNextDouble()) {
                        System.out.println("Please enter a valid number.");
                        input.next(); // Consume the invalid input
                    }
                    double number = input.nextDouble();
                    numbers.add(number);
                
                    System.out.print("Enter an operation (add, subtract, etc.) or '0' to solve: ");
                    String operation = input.next();
                    if (!operation.equals("0")){
                    operationlist.add(operation);
                    

                
                    if (operation.equals("0")) {
                        isCalculating = false;
                        break; //    Exit the loop to perform the final calculation
                    }



                }
                
                }
        }
        input.close();
    }
}