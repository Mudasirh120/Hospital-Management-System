package com.mudasir.hospitalmanagementsystem.util;
import com.mudasir.hospitalmanagementsystem.service.Login;
import java.io.FileWriter;
import java.io.IOException;
public class RegisterWrite {
    public static void writeFile(String role){
       try {
        switch(role){
          case "Patient":
          FileWriter myPatients = new FileWriter("resources/patients.csv",true);
          myPatients.write(Login.getCnic() + "," + Login.getUserName() + "," + Login.getFatherName() + "," + Login.getCity()+ "," + Login.getAccountType() + "," + Login.getRecoveryKey()+ "," + Login.getPassword() +"\n");
          myPatients.close();
          break;
          case "Doctor":
          FileWriter myDoctors = new FileWriter("resources/doctors.csv",true);
          myDoctors.write(Login.getCnic() + "," + Login.getUserName() + "," + Login.getFatherName() + "," + Login.getCity()+ "," + Login.getAccountType() + "," + Login.getRecoveryKey()+ "," + Login.getPassword() +"\n");
          myDoctors.close();
          break;
          case "Admin":
          FileWriter myAdmins = new FileWriter("resources/admins.csv",true);
          myAdmins.write(Login.getCnic() + "," + Login.getUserName() + "," + Login.getFatherName() + "," + Login.getCity()+ "," + Login.getAccountType() + "," + Login.getRecoveryKey()+ "," + Login.getPassword() +"\n");
          myAdmins.close();
          break;
        }
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }
}
