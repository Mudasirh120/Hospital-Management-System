package com.mudasir.hospitalmanagementsystem;
import com.mudasir.hospitalmanagementsystem.service.Login;
import com.mudasir.hospitalmanagementsystem.util.CreateFiles;
public class Main {
    public static void main(String[] args) {
        CreateFiles.createFile();
        Login.loginPage();
    }
}

