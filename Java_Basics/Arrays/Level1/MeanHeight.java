import java.util.*;

public class MeanHeight {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double heights[] = new double[11];
        double sum = 0;

        System.out.println("Enter height of 11 football players:");

        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }

        for (int i = 0; i < heights.length; i++) {
            sum = sum + heights[i];
        }

        double mean = sum / heights.length;

        System.out.println("\nMean height of football team = " + mean);

        sc.close();
    }
}