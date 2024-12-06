package com.mudasir.hospitalmanagementsystem;
import com.mudasir.hospitalmanagementsystem.service.Login;
import com.mudasir.hospitalmanagementsystem.util.CreateFiles;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hospital Management System!");
        System.out.println("Initializing the system...");
        try {
            CreateFiles.createFile();
            System.out.println("System initialized successfully.");
        } catch (Exception e) {
            System.out.println("Error during system initialization: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        Login.loginPage();
    }
}
