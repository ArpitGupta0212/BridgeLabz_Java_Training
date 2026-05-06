import java.util.*;

public class NaturalNumberSumForLoop {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n > 0) {

            int sum = 0;

            for (int i = 1; i <= n; i++) {
                sum = sum + i;
            }

            int formulaSum = n * (n + 1) / 2;

            System.out.println("Sum using for loop = " + sum);
            System.out.println("Sum using formula = " + formulaSum);

            if (sum == formulaSum) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("Both computations are not correct.");
            }

        } else {
            System.out.println("Not a Natural Number");
        }

        sc.close();
    }
}