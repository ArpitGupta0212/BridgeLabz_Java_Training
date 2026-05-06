import java.util.*;

public class SumUsingBreak {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double total = 0.0;

        while (true) {

            System.out.print("Enter a number: ");
            double num = sc.nextDouble();

            if (num <= 0) {
                break;
            }

            total = total + num;
        }

        System.out.println("Total Sum = " + total);

        sc.close();
    }
}