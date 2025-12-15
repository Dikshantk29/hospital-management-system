package models;
import java.time.LocalDateTime;


public class Appointment {

    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime dateTime;
    private String status;

    public Appointment(String appointmentId, Patient patient, Doctor doctor, LocalDateTime dateTime) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.status = "Scheduled";
    }

    public void cancelAppointment() {
        status = "Cancelled";
    }
    public void getAppointmentDetails() {
        System.out.println("=== Appointment information ===");
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient Name: " + patient.getName());
        System.out.println("Doctor Name: " + doctor.getName());
        System.out.println("Date & Time: " + dateTime);
        System.out.println("Status: " + status);


    }
}
