package de.rubeen.ils;

import java.util.Date;

import de.rubeen.ils.enums.EmergencyType;
import de.rubeen.ils.enums.Status;

/**
 * Created by rubeen on 05.06.17.
 */

public class Operation {
    //Fields
    private String title;
    private Date startTime;
    private Date endTime;
    private Status status;
    private int neededForce;
    private int progress;
    private EmergencyType emergencyType;

    public Operation(String title, Date startTime, int neededForce, EmergencyType emergencyType, Status status, Date endTime) {
        this(title, startTime, neededForce, emergencyType, status);
        this.endTime = endTime;
    }

    public Operation(String title, Date startTime, int neededForce, EmergencyType emergencyType, Status status) {
        this(title, startTime, neededForce, emergencyType);
        this.status = status;
    }

    public Operation(String title, Date startTime, int neededForce, EmergencyType emergencyType) {
        this.title = title;
        this.startTime = startTime;
        this.neededForce = neededForce;
        this.emergencyType = emergencyType;
    }


    //Getter
    public String getTitle() {
        return title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Status getStatus() {
        return status;
    }

    public int getNeededForce() {
        return neededForce;
    }

    public int getProgress() {
        return progress;
    }

    //Methods
    public void work(WorkForce workForce) {
        if (workForce.getEmergencyType() == emergencyType) {
            progress = progress - (workForce.getForce() / neededForce);
            return;
        }
    }

}

