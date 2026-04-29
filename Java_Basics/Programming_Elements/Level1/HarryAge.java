package Core_Programming.Core_Programming_Basics.Elementary_Program;

import java.util.*;

public class HarryAge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter birth year: ");
        int birth = sc.nextInt();

        int curr = 2026;

        int age = curr - birth;

        System.out.println("Harry Age in 2026 is " + age);
    }
}