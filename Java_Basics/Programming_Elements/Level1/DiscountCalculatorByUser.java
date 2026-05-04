import java.util.*;
public class DiscountCalculatorByUser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter student fee: ");
        double fee = sc.nextDouble();

       
        System.out.print("Enter discount percent: ");
        double discountPercent = sc.nextDouble();

    
        double discount = (fee * discountPercent) / 100;

        double finalFee = fee - discount;

       
        System.out.println("The discount amount is INR " + discount);
        System.out.println("The final discounted fee is INR " + finalFee);

        sc.close();
    }

}
