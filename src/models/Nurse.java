package models;

public class Nurse extends Person {
    private String nurseId;
    private String shift;
    private String assignedWard;

    public Nurse(String id, String name, int age, String gender, String contactNumber, String nurseId, String shift, String assignedWard) {
        super(id, name, age, gender, contactNumber);
        this.nurseId = nurseId;
        this.shift = shift;
        this.assignedWard = assignedWard;
    }


    @Override
    public void displayInfo() {
        System.out.println("=== Nurse Information ===");
        System.out.println("Nurse ID: " + nurseId);
        System.out.println("Nurse Name: " + getName());
        System.out.println("Nurse Age: " + getAge());
        System.out.println("Nurse Gender: " + getGender());
        System.out.println("Nurse Contact Number: " + getContactNumber());
        System.out.println("Nurse Shift: " + shift);
        System.out.println("Nurse Assigned Ward: " + assignedWard);


    }

//    public void assistDoctor(Doctor doctor, Patient patient) {
//        patient.addMedicalHistory(
//                "Assisted by Nurse " + getName() + " during consultation with Dr. " + doctor.getName()
//        );
//    }

    public void checkVitals(Patient patient, String vitals) {
        if (vitals == null || vitals.trim().isEmpty()) {
            return;
        }
        String note = "Vitals checked by Nurse " + getName() + ": " + vitals;

        if (patient == null) return;

        patient.addMedicalHistory(note);


    }
}
