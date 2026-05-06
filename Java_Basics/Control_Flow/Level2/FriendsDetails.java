import java.util.*;

public class FriendsDetails {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amar Age: ");
        int amarAge = sc.nextInt();

        System.out.print("Enter Akbar Age: ");
        int akbarAge = sc.nextInt();

        System.out.print("Enter Anthony Age: ");
        int anthonyAge = sc.nextInt();

        System.out.print("Enter Amar Height: ");
        double amarHeight = sc.nextDouble();

        System.out.print("Enter Akbar Height: ");
        double akbarHeight = sc.nextDouble();

        System.out.print("Enter Anthony Height: ");
        double anthonyHeight = sc.nextDouble();

        if (amarAge < akbarAge && amarAge < anthonyAge) {
            System.out.println("Amar is the Youngest");
        } 
        else if (akbarAge < amarAge && akbarAge < anthonyAge) {
            System.out.println("Akbar is the Youngest");
        } 
        else {
            System.out.println("Anthony is the Youngest");
        }

        if (amarHeight > akbarHeight && amarHeight > anthonyHeight) {
            System.out.println("Amar is the Tallest");
        } 
        else if (akbarHeight > amarHeight && akbarHeight > anthonyHeight) {
            System.out.println("Akbar is the Tallest");
        } 
        else {
            System.out.println("Anthony is the Tallest");
        }

        sc.close();
    }
}