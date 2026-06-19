package org.Csv_Handling;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Csv_reader {
    public static  void main(String args[]) {
        {
            try {
                FileReader file = new FileReader("Student.csv");
                CSVReader reader = new CSVReader(file);
                String[] row;
                while ((row = reader.readNext()) != null) {
                    for (String i : row) {
                        System.out.print(i+" ");
                    }
                    System.out.println();
                }
                reader.close();
            } catch (Exception e) {
            }
        }
    }
}
