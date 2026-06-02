import java.io.*;

public class FileOutputStream1 {
    public static void main(String[] args) {

        try {

            FileOutputStream fos =
                    new FileOutputStream("test.txt");

            String msg = "Hello Java";

            fos.write(msg.getBytes());

            fos.close();

            System.out.println("Written");

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}