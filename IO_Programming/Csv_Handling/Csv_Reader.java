import java.io.BufferedReader;
import java.io.FileReader;

public class Csv_Reader{
    public static void main(String args[]){
        String str="Student.csv";
        try{
        FileReader file=new FileReader(str);
        BufferedReader br=new BufferedReader(file);
        String line;
        while((line=br.readLine())!=null){
            String data[]=line.split(",");
            for(String d:data){
                System.out.print(d);
            }
            System.out.println();
        }
        }
        catch(Exception e){

        }
}
}