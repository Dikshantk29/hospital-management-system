package models;

import java.time.LocalDateTime;

public class AdmissionDetails {
    private String ward;
    private String roomNumber;
    private String bedNumber;
    private LocalDateTime admissionTimestamp;
    private String reason;
    private String status;
    // e.g. "Admitted", "Discharged", "Transferred"
    private LocalDateTime dischargeTimestamp;

    public AdmissionDetails(String ward, String roomNumber, String bedNumber, String reason) {
        this.ward = ward;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admissionTimestamp = LocalDateTime.now();
        this.reason = reason;
        this.status = "Admitted";
    }

    //setter
    public void setStatus(String status) {
        this.status = status;
    }

    public void setDischargeTimestamp(LocalDateTime dischargeTimestamp) {
        this.dischargeTimestamp = dischargeTimestamp;
    }

    //getter
    public String getWard() {
        return ward;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public LocalDateTime getAdmissionTimestamp() {
        return admissionTimestamp;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDischargeTimestamp() {
        return dischargeTimestamp;
    }

}
