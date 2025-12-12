package models;

public class Nurse extends Person {
    private String nurseId;
    private String shift;
    private String assignedWard;

    public Nurse(String nurseId, String shift, String assignedWard) {
        super();
        this.nurseId = nurseId;
        this.shift = shift;
        this.assignedWard = assignedWard;
    }


    @Override
    public void displayInfo() {

    }

    public void assistDoctor() {

    }

    public void checkVitals() {

    }
}
