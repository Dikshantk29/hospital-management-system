package models;

public class Doctor  extends  Person{
    private String doctorId;
    private String specialization;
    private int availableHours;

    public Doctor(String doctorId, String specialization, int availableHours){
        super();
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.availableHours = availableHours;

    }

    @Override
    void displayInfo() {

    }

    public void consultPatient(){

    }
    public void prescribemedicine(){

    }
}
