import java.util.*;

public class EmployeeBonus {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10];
        double[] service = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {

            System.out.println("Enter details of Employee " + (i + 1));

            System.out.print("Enter Salary: ");
            salary[i] = sc.nextDouble();

            System.out.print("Enter Years of Service: ");
            service[i] = sc.nextDouble();

            if (salary[i] <= 0 || service[i] < 0) {
                System.out.println("Invalid Input! Enter Again");
                i--;
            }
        }

        for (int i = 0; i < 10; i++) {

            if (service[i] > 5) {
                bonus[i] = salary[i] * 5 / 100;
            } else {
                bonus[i] = salary[i] * 2 / 100;
            }

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("\nEmployee Details");

        for (int i = 0; i < 10; i++) {

            System.out.println("\nEmployee " + (i + 1));
            System.out.println("Old Salary = " + salary[i]);
            System.out.println("Bonus = " + bonus[i]);
            System.out.println("New Salary = " + newSalary[i]);
        }

        System.out.println("\nTotal Old Salary = " + totalOldSalary);
        System.out.println("Total Bonus = " + totalBonus);
        System.out.println("Total New Salary = " + totalNewSalary);

        sc.close();
    }
}