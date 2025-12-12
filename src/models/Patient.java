package models;

public class Patient extends  Person {
    private String patientId;
    private String medicalHistory;
    private String currentWard;

    public Patient(String patientId,String medicalHistory,String currentWard ){
        super();
        this.patientId =patientId;
        this.medicalHistory =medicalHistory;
        this.currentWard = currentWard;

    }

    @Override
    void displayInfo() {

    }

    public void admitPatient(){}

    public void dichargePatient(){}


}
