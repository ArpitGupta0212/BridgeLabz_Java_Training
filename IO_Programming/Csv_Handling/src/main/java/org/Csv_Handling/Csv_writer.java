package org.Csv_Handling;

import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;

public class Csv_writer {
    public static  void main(String args[]){
        try {
            FileWriter file=new FileWriter("Student.csv");
            CSVWriter writer=new CSVWriter(file);
            String[] header={"Name","Class","Marks"};
            writer.writeNext(header);
            String[] data1 = { "Aman", "10", "620" };
            writer.writeNext(data1);
            String[] data2 = { "Suraj", "10", "630" };
            writer.writeNext(data2);
            writer.close();
        }
        catch (Exception e){

        }
    }
}
