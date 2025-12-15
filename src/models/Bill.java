package models;

import java.time.LocalDateTime;

public class Bill {

    private String billId;
    private Patient patient;
    private double consultationFee;
    private double medicineCharges;
    private double totalAmount;
    private LocalDateTime billDate;

    // Constructor
    public Bill(String billId, Patient patient, double consultationFee, double medicineCharges) {
        this.billId = billId;
        this.patient = patient;
        this.consultationFee = consultationFee;
        this.medicineCharges = medicineCharges;
        this.billDate = LocalDateTime.now();
        calculateBill();
    }

    // Calculate total bill amount
    public void calculateBill() {
        this.totalAmount = consultationFee + medicineCharges;
    }

    // Generate bill (simple confirmation)
    public void generateBill() {
        System.out.println("Bill generated for patient: " + patient.getName());
    }

    // Display bill details
    public void displayBill() {
        System.out.println("=== Bill Details ===");
        System.out.println("Bill ID: " + billId);
        System.out.println("Patient Name: " + patient.getName());
        System.out.println("Consultation Fee: " + consultationFee);
        System.out.println("Medicine Charges: " + medicineCharges);
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Bill Date: " + billDate);
    }
}
