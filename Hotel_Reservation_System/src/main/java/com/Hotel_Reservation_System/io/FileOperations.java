package com.Hotel_Reservation_System.io;

import java.io.*;

public class FileOperations {
    public static void verifyDirectories(String dirPath) {

        File dir = new File(dirPath);

        if (!dir.exists()) {

            if (dir.mkdirs()) {
                System.out.println("Directory Created");
            }
        }
    }

    public static void backupCatalog(File source, File destination) {

        try (FileReader reader = new FileReader(source); FileWriter writer = new FileWriter(destination)) {

            int ch;

            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }

            System.out.println("Catalog Backup Completed");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyBinaryLog(File source, File destination) {

        try (FileInputStream fis = new FileInputStream(source);

             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];

            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {

                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Binary Copy Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeReceipt(String filePath, String receiptContent) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            writer.write(receiptContent);

            writer.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
