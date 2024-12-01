package com.mudasir.hospitalmanagementsystem.util;
import com.mudasir.hospitalmanagementsystem.service.Login;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterWrite {
    public static void writeFile(){
       try {
      FileWriter myWriter = new FileWriter("resources/users.csv",true);
      myWriter.write(Login.accountNumber + "," + Login.username + "," + Login.password + "," + Login.recoverykey + "\n");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }
}
