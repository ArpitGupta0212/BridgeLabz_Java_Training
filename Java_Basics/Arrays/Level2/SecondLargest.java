import java.util.*;

public class SecondLargest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int maxDigit = 10;

        int[] arr = new int[maxDigit];

        int index = 0;

        System.out.print("Enter a Number: ");
        int number = sc.nextInt();

        while (number != 0) {

            int digit = number % 10;

            arr[index] = digit;

            index++;

            if (index == maxDigit) {
                break;
            }

            number = number / 10;
        }

        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {

            if (arr[i] > largest) {

                secondLargest = largest;
                largest = arr[i];

            } else if (arr[i] > secondLargest && arr[i] != largest) {

                secondLargest = arr[i];
            }
        }

        System.out.println("Largest Digit = " + largest);
        System.out.println("Second Largest Digit = " + secondLargest);

        sc.close();
    }
}