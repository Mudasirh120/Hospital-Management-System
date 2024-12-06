package com.mudasir.hospitalmanagementsystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Appointment {
    private String patientCnic;
    private String doctorName;
    private String timeSlot;
    public Appointment(String patientCnic, String doctorName, String timeSlot) {
        this.patientCnic = patientCnic;
        this.doctorName = doctorName;
        this.timeSlot = timeSlot;
    }
    @Override
    public String toString() {
        return "Doctor: " + doctorName + ", Time Slot: " + timeSlot;
    }
    public String getPatientCnic() {
        return patientCnic;
    }
    public String getTimeSlot() {
        return timeSlot;
    }
    public String getDoctorName() {
        return doctorName;
    }
private static HashMap<String, List<Appointment>> appointments = new HashMap<>();
public static void bookAppointment() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter your CNIC: ");
    String patientCnic = scanner.nextLine();
    System.out.print("Enter Doctor's Name: ");
    String doctorName = scanner.nextLine();
    System.out.print("Enter Time Slot (e.g., 10:00 AM - 10:30 AM): ");
    String timeSlot = scanner.nextLine();
    if (appointments.containsKey(patientCnic)) {
        for (Appointment appt : appointments.get(patientCnic)) {
            if (appt.getTimeSlot().equals(timeSlot) && appt.getDoctorName().equals(doctorName)) {
                System.out.println("This slot is already booked. Choose another slot.");
                return;
            }
        }
    }

    Appointment newAppointment = new Appointment(patientCnic, doctorName, timeSlot);
    appointments.putIfAbsent(patientCnic, new ArrayList<>());
    appointments.get(patientCnic).add(newAppointment);
    System.out.println("Appointment booked successfully!");
}

}
