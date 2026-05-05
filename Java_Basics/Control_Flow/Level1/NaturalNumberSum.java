public class NaturalNumberSum {
    public static void main(String[] args) {

        int num = 5;  // You can change this value

        if (num > 0) {
            int sum = num * (num + 1) / 2;
            System.out.println("The sum of " + num + " natural numbers is " + sum);
        } else {
            System.out.println("The number " + num + " is not a natural number");
        }
    }
}