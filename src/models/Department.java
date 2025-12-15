package models;

import java.util.ArrayList;
import java.util.List;


public class Department {

    private String departmentId;
    private String departmentName;
    private Doctor headDoctor;
    private List<Doctor> doctors;
    private List<Nurse> nurses;

    public Department(String departmentId,
                      String departmentName,
                      Doctor headDoctor,
                      List<Doctor> doctors,
                      List<Nurse> nurses) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headDoctor = headDoctor;
        this.doctors = (doctors == null) ? new ArrayList<>() : doctors;
        this.nurses = (nurses == null) ? new ArrayList<>() : nurses;
    }

    public void addDoctor(Doctor doctor) {
        if (doctor == null) {
            return;
        }
        doctors.add(doctor);

    }

    public void addNurse(Nurse nurse) {
        if (nurse == null) {
            return;
        }
        nurses.add(nurse);

    }

    public void displayDepartmentInfo() {
        System.out.println("=== Department Information ===");
        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departmentName);

        // Head Doctor
        System.out.print("Head Doctor: ");
        if (headDoctor == null) {
            System.out.println("None");
        } else {
            System.out.println(headDoctor.getName());
        }

        // Doctors
        System.out.println("Doctors:");
        if (doctors.isEmpty()) {
            System.out.println(" - None");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println(" - " + doctor.getName());
            }
        }

        // Nurses
        System.out.println("Nurses:");
        if (nurses.isEmpty()) {
            System.out.println(" - None");
        } else {
            for (Nurse nurse : nurses) {
                System.out.println(" - " + nurse.getName());
            }
        }
    }

}
