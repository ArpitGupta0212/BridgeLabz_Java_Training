import java.util.*;

public class SquarePerimeter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side of square: ");
        double side = sc.nextDouble();

        double perimeter = 4 * side;

        System.out.println("Perimeter of square is: " + perimeter);

        sc.close();
    }
}