import java.util.*;
public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

     
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

     
        double add = num1 + num2;
        double sub = num1 - num2;
        double mul = num1 * num2;
        double div = num1 / num2;


        System.out.println("Addition: " + add);
        System.out.println("Subtraction: " + sub);
        System.out.println("Multiplication: " + mul);

        if (num2 != 0) {
            System.out.println("Division: " + div);
        } else {
            System.out.println("Division: Not possible (division by zero)");
        }

        sc.close();
    }
}

