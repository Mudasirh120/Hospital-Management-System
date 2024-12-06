package com.mudasir.hospitalmanagementsystem.util;
import java.io.File;
import java.io.IOException;
public class CreateFiles {
    public static void createFile() {
        File resourcesDir = new File("resources");
        if (!resourcesDir.exists() && !resourcesDir.mkdir()) {
            throw new RuntimeException("Failed to create 'resources' directory.");
        }
        String[] fileNames = {"patients.csv", "doctors.csv", "admins.csv"};
        for (String fileName : fileNames) {
            File file = new File(resourcesDir, fileName);
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists: " + file.getName());
                }
            } catch (IOException e) {
                throw new RuntimeException("Error creating file: " + file.getName(), e);
            }
        }
    }
}
