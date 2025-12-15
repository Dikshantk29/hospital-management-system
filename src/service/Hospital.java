package service;

import models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private String hospitalName;
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Department> departments;
    private List<Appointment> appointments;

    // Constructor
    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.departments = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    //PATIENT MANAGEMENT

    public void registerPatient(Patient patient) {
        if (patient == null) return;
        patients.add(patient);
    }

    public Patient searchPatient(String name) {
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public Patient searchPatientById(String id) {
        for (Patient p : patients) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public void displayAllPatients() {
        System.out.println("=== All Patients ===");
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }
        for (Patient p : patients) {
            p.displayInfo();
        }
    }

    //DOCTOR MANAGEMENT

    public void registerDoctor(Doctor doctor) {
        if (doctor == null) return;
        doctors.add(doctor);
    }

    public Doctor searchDoctor(String specialization) {
        for (Doctor d : doctors) {
            if (d.getSpecialization().equalsIgnoreCase(specialization)) {
                return d;
            }
        }
        return null;
    }

    public void displayAllDoctors() {
        System.out.println("=== All Doctors ===");
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered.");
            return;
        }
        for (Doctor d : doctors) {
            d.displayInfo();
        }
    }

    // APPOINTMENT MANAGEMENT

    public Appointment bookAppointment(Patient patient, Doctor doctor, LocalDateTime dateTime) {
        if (patient == null || doctor == null || dateTime == null) return null;

        String appointmentId = "APT" + System.currentTimeMillis();
        Appointment appointment = new Appointment(appointmentId, patient, doctor, dateTime);
        appointments.add(appointment);
        return appointment;
    }

    public void displayAllAppointments() {
        System.out.println("=== All Appointments ===");
        if (appointments.isEmpty()) {
            System.out.println("No appointments booked.");
            return;
        }
        for (Appointment a : appointments) {
            a.getAppointmentDetails();
        }
    }

    // DEPARTMENT MANAGEMENT

    public void addDepartment(Department department) {
        if (department == null) return;
        departments.add(department);
    }

    public void displayAllDepartments() {
        System.out.println("=== All Departments ===");
        if (departments.isEmpty()) {
            System.out.println("No departments available.");
            return;
        }
        for (Department d : departments) {
            d.displayDepartmentInfo();
        }
    }

    // BASIC INFO

    public void displayHospitalInfo() {
        System.out.println("=== Hospital Information ===");
        System.out.println("Hospital Name: " + hospitalName);
        System.out.println("Total Patients: " + patients.size());
        System.out.println("Total Doctors: " + doctors.size());
        System.out.println("Total Departments: " + departments.size());
        System.out.println("Total Appointments: " + appointments.size());
    }
}
