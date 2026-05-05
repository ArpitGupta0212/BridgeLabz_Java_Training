public class LargestCheck {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 25;
        int num3 = 20;

      
        if (num1 > num2 && num1 > num3) {
            System.out.println("Is the first number the largest? Yes");
        } else {
            System.out.println("Is the first number the largest? No");
        }

        if (num2 > num1 && num2 > num3) {
            System.out.println("Is the second number the largest? Yes");
        } else {
            System.out.println("Is the second number the largest? No");
        }

   
        if (num3 > num1 && num3 > num2) {
            System.out.println("Is the third number the largest? Yes");
        } else {
            System.out.println("Is the third number the largest? No");
        }
    }
}