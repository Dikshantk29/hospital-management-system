package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Prescription {

    private String prescriptionId;
    private Patient patient;
    private Doctor doctor;
    private List<String> medicines;
    private String instructions;
    private LocalDateTime date;

    // constructor
    public Prescription(String prescriptionId, Patient patient, Doctor doctor,
                        List<String> medicines, String instructions) {
        this.prescriptionId = prescriptionId;
        this.patient = patient;
        this.doctor = doctor;
        this.medicines = (medicines == null) ? new ArrayList<>() : medicines;
        this.instructions = instructions;
        this.date = LocalDateTime.now();
    }

    // helper
    public void addMedicine(String medicine) {
        if (medicine == null || medicine.trim().isEmpty()) return;
        medicines.add(medicine.trim());
    }

    //  handle null patient/doctor  with formatted date
    public void displayPrescription() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println("=== Prescription Details ===");
        System.out.println("Prescription ID: " + prescriptionId);
        System.out.println("Patient: " + (patient == null ? "N/A" : patient.getName()));
        System.out.println("Doctor: " + (doctor == null ? "N/A" : doctor.getName()));
        System.out.println("Date: " + (date == null ? "N/A" : date.format(fmt)));

        System.out.println("Medicines:");
        if (medicines == null || medicines.isEmpty()) {
            System.out.println(" - None");
        } else {
            for (String m : medicines) {
                System.out.println(" - " + m);
            }
        }

        System.out.println("Instructions: " + (instructions == null ? "N/A" : instructions));
    }

    // --- getters (defensive where appropriate) ---
    public String getPrescriptionId() { return prescriptionId; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public List<String> getMedicines() { return new ArrayList<>(medicines); }
    public String getInstructions() { return instructions; }
    public LocalDateTime getDate() { return date; }
}
