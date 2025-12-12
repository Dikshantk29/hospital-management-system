package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Simple, easy-to-read Doctor model.
 * - availableHours: map of slotKey -> hours (e.g. "Mon_morning" -> "09:00-12:00")
 * - consultPatient: optionally writes a timestamped note into patient's history
 * - prescribeMedicine: creates a Prescription and optionally adds a readable note to patient's history
 */
public class Doctor extends Person {
    private String doctorId;
    private String specialization;
    private Map<String, String> availableHours;

    // Constructor: initialize fields. If availableHours is null, create an empty map.
    public Doctor(String id, String name, int age, String gender, String contactNumber,
                  String doctorId, String specialization, Map<String, String> availableHours) {
        super(id, name, age, gender, contactNumber);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.availableHours = (availableHours == null) ? new HashMap<>() : availableHours;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Doctor Information ===");
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Name: " + getName());
        System.out.println("Specialization: " + specialization);

        // Print available hours
        System.out.println("Available Hours:");
        if (availableHours == null || availableHours.isEmpty()) {
            System.out.println(" - Not Available");
        } else {
            for (Map.Entry<String, String> entry : availableHours.entrySet()) {
                System.out.println(" " + entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    /**
     * Record a consultation.
     * If updateHistory is true, add a note to patient's medical history with a timestamp.
     */
    public void consultPatient(Patient patient, String notes, boolean updateHistory) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String time = LocalDateTime.now().format(fmt);
        String consultationNote = "Dr. " + getName() + " consulted patient on " + time + ": " + notes;

        if (updateHistory) {
            patient.addMedicalHistory(consultationNote);
        }

        System.out.println("Consultation recorded for patient: " + patient.getName());
    }

    /**
     * Create a Prescription for a patient.
     * Returns the Prescription object and optionally appends a readable note to the patient's history.
     */
    public Prescription prescribeMedicine(Patient patient, List<String> medicines, String instructions, boolean updateHistory) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }

        // Simple unique ID based on time
        String prescriptionId = "PR" + System.currentTimeMillis();

        // Safe copy of medicines list
        List<String> meds = (medicines == null) ? new ArrayList<>() : new ArrayList<>(medicines);

        // Create prescription
        Prescription prescription = new Prescription(prescriptionId, patient, this, meds, instructions);

        // Optionally add a readable line to patient's medical history
        if (updateHistory) {
            // Format timestamp simply and clearly
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String timestamp = LocalDateTime.now().format(fmt);

            String medsSummary = meds.isEmpty() ? "No medicines" : String.join(", ", meds);
            String historyNote = "Prescription by Dr. " + getName() + " on " + timestamp
                    + ": " + medsSummary + ". Instructions: " + (instructions == null ? "N/A" : instructions);

            patient.addMedicalHistory(historyNote);
        }

        System.out.println("Prescription created: " + prescriptionId + " for patient " + patient.getName());
        return prescription;
    }
}
