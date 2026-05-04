import java.util.*;

public class DistanceConverter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance in feet: ");
        double feet = sc.nextDouble();

        double yards = feet / 3;
        double miles = feet / (3 * 1760);

        System.out.println("Distance in yards: " + yards);
        System.out.println("Distance in miles: " + miles);

        sc.close();
    }
}