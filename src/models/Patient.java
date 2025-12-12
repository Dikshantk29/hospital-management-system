package models;

import models.AdmissionDetails;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {

    private String patientId;
    private List<String> medicalHistory;
    private AdmissionDetails admissionDetails;

    public Patient(String id, String name, int age, String gender, String contactNumber,
                   String patientId, List<String> medicalHistory, AdmissionDetails admissionDetails) {
        super(id, name, age, gender, contactNumber);
        this.patientId = patientId;
        // avoid NPE: use empty list when null
        this.medicalHistory = (medicalHistory == null) ? new ArrayList<>() : medicalHistory;
        this.admissionDetails = admissionDetails;

    }

    @Override
    public void displayInfo() {
        System.out.println("===Patient Information===");
        System.out.println("ID: " + getId());
        System.out.println("Patient Name: " + getName());
        System.out.println("Patient Age: " + getAge());
        System.out.println("Patient Gender: " + getGender());
        System.out.println("Patient Contact Number: " + getContactNumber());
        System.out.println("Patient ID: " + patientId);
        System.out.println("Admission Details:");
        if (admissionDetails == null) {
            System.out.println(" - None");


        } else {
            System.out.println(" Ward: " + admissionDetails.getWard());
            System.out.println(" Room: " + admissionDetails.getRoomNumber());
            System.out.println(" Bed: " + admissionDetails.getBedNumber());
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            System.out.println(" Admitted On: " + (admissionDetails.getAdmissionTimestamp() == null ? "N/A" : admissionDetails.getAdmissionTimestamp().format(fmt)));
            System.out.println(" Reason: " + admissionDetails.getReason());
            System.out.println(" Status: " + admissionDetails.getStatus());
            LocalDateTime d = admissionDetails.getDischargeTimestamp();
            System.out.println(" Discharged On: " + (d == null ? "N/A" : d.format(fmt)));
        }
//      System.out.println("Patient Current Ward: " + currentWard);
        System.out.println("Medical History:");
        if (medicalHistory == null || medicalHistory.isEmpty()) {
            System.out.println(" - None");
        } else {
            for (String record : medicalHistory) {
                System.out.println(" - " + record);
            }
        }


    }

    public void admitPatient(String ward, String roomNumber, String bedNumber, String reason) {
        this.admissionDetails = new AdmissionDetails(ward, roomNumber, bedNumber, reason);
    }

    public void dischargePatient() {
        if (admissionDetails == null) {
            System.out.println(getName() + " is not currently admitted.");
            return;
        }
        admissionDetails.setStatus("Discharged");
        admissionDetails.setDischargeTimestamp(LocalDateTime.now());
    }


    //helper
    public void addMedicalHistory(String entry) {
        if (entry == null || entry.trim().isEmpty()) return;
        medicalHistory.add(entry.trim());
    }

    public boolean removeMedicalHistory(String entry) {
        return medicalHistory.remove(entry);
    }

    public List<String> getMedicalHistory() {
        return new ArrayList<>(medicalHistory);
    }


}
