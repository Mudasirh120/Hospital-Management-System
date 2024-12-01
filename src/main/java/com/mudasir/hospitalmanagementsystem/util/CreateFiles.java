package com.mudasir.hospitalmanagementsystem.util;
import java.io.File;
import java.io.IOException;
public class CreateFiles {
    public static void createFile(){
        try {
            File myUsers = new File("resources/patients.csv");
            File myDocs = new File("resources/doctors.csv");
            File myAdmins = new File("resources/admins.csv");
            if (myUsers.createNewFile() && myDocs.createNewFile() && myAdmins.createNewFile()) {
              System.out.println("Files created: " + myUsers.getName() +","+myDocs.getName()+","+myAdmins.getName());
            } else {
              System.out.println("Files already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
}
