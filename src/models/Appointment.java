package models;

import java.sql.Time;
import java.util.Date;

public class Appointment {

    private String appointmentId;
    private String patient;
    private String doctor;
    private Date date;
    private Time time;
    private String status;

    public Appointment(String appointmentId, String patient, String doctor, Date date, Time time, String status) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.status = status;

    }

    public void scheduleAppointment(){}
    public void cancelAppointment(){}
    public void getAppointmentDetails(){}
}
