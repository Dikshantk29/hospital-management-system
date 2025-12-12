import models.Doctor;
import models.Patient;
import models.AdmissionDetails;
import models.Prescription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // STEP 1: Create a patient with no admission details yet
        Patient p = new Patient(
                "P001",
                "Rahul Sharma",
                28,
                "Male",
                "9876543210",
                "PT1001",
                new ArrayList<>(),    // empty medical history
                null                  // not admitted
        );

        p.displayInfo(); // Test 1: Should show Admission Details = None

        System.out.println("----- Admitting Patient -----");

        // STEP 2: Admit the patient
        p.admitPatient("General Ward", "12A", "Bed-4", "Fever Observation");

        p.displayInfo(); // Test 2: Should show admission details

        System.out.println("----- Discharging Patient -----");

        // STEP 3: Discharge the patient
        p.dischargePatient();

        p.displayInfo(); // Test 3: Should show discharged status + timestamp

        // after admitting and consulting tests you already have:
        List<String> meds = new ArrayList<>();
        meds.add("Paracetamol 500mg");
        meds.add("Amoxicillin 250mg");

        Doctor dr = new Doctor("D001","Ramesh Kumar",45,"Male","9123456780","DR100","General Medicine", new HashMap<>());
        p = new Patient("P002", "Anita Roy", 34, "Female", "9012345678", "PT200", new ArrayList<>(), null);

        Prescription pr = dr.prescribeMedicine(p, meds, "Take after food, twice a day", true);
        pr.displayPrescription();
        p.displayInfo(); // to see the note in medical history


    }
}
