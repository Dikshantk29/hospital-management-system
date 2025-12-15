import service.Hospital;
import models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Hospital hospital = new Hospital("City Hospital");

        boolean running = true;

        while (running) {

            System.out.println("\n========== HOSPITAL MANAGEMENT SYSTEM ==========");
            System.out.println("1. Register Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Register Doctor");
            System.out.println("4. View All Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View All Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                /* === PATIENT === */
                case 1:
                    System.out.print("Enter Patient ID: ");
                    String pid = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String pname = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int page = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Gender: ");
                    String pgender = sc.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String pcontact = sc.nextLine();

                    System.out.print("Enter Patient Code: ");
                    String patientCode = sc.nextLine();

                    Patient patient = new Patient(
                            pid,
                            pname,
                            page,
                            pgender,
                            pcontact,
                            patientCode,
                            new ArrayList<>(),
                            null
                    );

                    hospital.registerPatient(patient);
                    System.out.println("Patient registered successfully.");
                    break;

                case 2:
                    hospital.displayAllPatients();
                    break;

                /* === DOCTOR === */
                case 3:
                    System.out.print("Enter Doctor ID: ");
                    String did = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String dname = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int dage = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Gender: ");
                    String dgender = sc.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String dcontact = sc.nextLine();

                    System.out.print("Enter Doctor Code: ");
                    String doctorCode = sc.nextLine();

                    System.out.print("Enter Specialization: ");
                    String specialization = sc.nextLine();

                    Doctor doctor = new Doctor(
                            did,
                            dname,
                            dage,
                            dgender,
                            dcontact,
                            doctorCode,
                            specialization,
                            new HashMap<>()
                    );

                    hospital.registerDoctor(doctor);
                    System.out.println("Doctor registered successfully.");
                    break;

                case 4:
                    hospital.displayAllDoctors();
                    break;

                /* === APPOINTMENT === */
                case 5:
                    System.out.print("Enter Patient Name: ");
                    String searchPatientName = sc.nextLine();

                    Patient apPatient = hospital.searchPatient(searchPatientName);
                    if (apPatient == null) {
                        System.out.println("Patient not found.");
                        break;
                    }

                    System.out.print("Enter Doctor Specialization: ");
                    String searchSpec = sc.nextLine();

                    Doctor apDoctor = hospital.searchDoctor(searchSpec);
                    if (apDoctor == null) {
                        System.out.println("Doctor not available.");
                        break;
                    }

                    Appointment appointment = hospital.bookAppointment(
                            apPatient,
                            apDoctor,
                            LocalDateTime.now().plusDays(1)
                    );

                    System.out.println("Appointment booked successfully.");
                    appointment.getAppointmentDetails();
                    break;

                case 6:
                    hospital.displayAllAppointments();
                    break;

                /* ================= EXIT ================= */
                case 7:
                    running = false;
                    System.out.println("Thank you for using Hospital Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
