


public class HeightConverter {
    public static void main(String[] args) {
        double cm =300;


        double totalInches = cm / 2.54;

 
        int feet = (int) (totalInches / 12);
        double inches = totalInches % 12;

        System.out.println("Your height in cm is " + cm +
                " while in feet is " + feet +
                " and inches is " + inches);


    }
}

