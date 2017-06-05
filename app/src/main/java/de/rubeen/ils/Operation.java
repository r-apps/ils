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
    private Address address;
    private Date startTime;
    private Date endTime;
    private Status status;
    private double neededForce;
    private double progress;
    private int maxProgress;
    private EmergencyType emergencyType;

    public Operation(String title, Date startTime, int neededForce, EmergencyType emergencyType, Address address, Status status, Date endTime) {
        this(title, startTime, neededForce, emergencyType, address, status);
        this.endTime = endTime;
    }

    public Operation(String title, Date startTime, int neededForce, EmergencyType emergencyType, Address address, Status status) {
        this(title, startTime, neededForce, emergencyType, address);
        this.status = status;
    }

    public Operation(String title, Date startTime, int neededForce, EmergencyType emergencyType, Address address) {
        this.title = title;
        this.startTime = startTime;
        this.neededForce = neededForce;
        this.emergencyType = emergencyType;
        this.address = address;
        maxProgress = 10000;
        this.status = Status.open;
    }


    //Getter
    public String getTitle() {
        return title;
    }

    public Address getAddress() {
        return address;
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

    public double getNeededForce() {
        return neededForce;
    }

    public double getProgress() {
        return (int) progress;
    }

    public double getMaxProgress() {
        return maxProgress;
    }

    //Setter
    private void addProgress(double progress) {
        if (status == Status.inProgress)
            if (progress + this.progress < getMaxProgress())
                this.progress += progress;
            else {
                this.progress = maxProgress;
                status = Status.sucess;
            }
    }

    //Methods
    public void work(WorkForce workForce) {
        if (workForce.getEmergencyType() == emergencyType) {
            if (status == Status.open)
                status = Status.inProgress;
            addProgress((workForce.getForce() / neededForce) * 100);
            return;
        }
    }

}

