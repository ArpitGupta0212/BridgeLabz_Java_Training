import java.util.*;

public class FactorialWhile {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        if (n >= 0) {

            int factorial = 1;
            int i = 1;

            while (i <= n) {
                factorial = factorial * i;
                i++;
            }

            System.out.println("Factorial = " + factorial);

        } else {
            System.out.println("Not a Natural Number");
        }

        sc.close();
    }
}