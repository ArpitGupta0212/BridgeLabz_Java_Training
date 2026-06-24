package com.LibraryManagementSystem.io;

import java.io.*;

public class FileOperations {

    // Create Directory if not exists
    public static void verifyDirectories(String dirPath) {

        File file = new File(dirPath);

        if (!file.exists()) {

            boolean created = file.mkdirs();

            System.out.println("Directory Created : " + created);
        } else {

            System.out.println("Directory Already Exists");
        }
    }

    // Binary Copy
    public static void backupDatabase(File source, File destination) throws IOException {

        try (FileInputStream fis = new FileInputStream(source);

             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];

            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {

                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Character Copy
    public static void archiveLogs(File source, File destination) throws IOException {

        try (FileReader fr = new FileReader(source);

             FileWriter fw = new FileWriter(destination)) {

            int character;

            while ((character = fr.read()) != -1) {

                fw.write(character);
            }
        }
    }

    // Receipt Writer
    public static void writeReceipt(String filePath, String receiptContent) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            bw.write(receiptContent);
        }
    }
}