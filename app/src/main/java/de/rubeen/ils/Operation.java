package de.rubeen.ils;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

import de.rubeen.ils.enums.OrganisationType;
import de.rubeen.ils.enums.Status;

/**
 * Created by rubeen on 05.06.17.
 *
 * Instance of an operation
 */

public class Operation {
    //Fields
    private final String title;
    private final Address address;
    private final Date startTime;
    private final int maxProgress;
    private Date endTime;
    private Status status;
    private double neededForce;
    private double progress;
    private OrganisationType organisationType;

    /**
     * advanced advanced operation with status and endTime
     *
     * @param title            readable for user
     * @param startTime        time operation started (maybe now)
     * @param neededForce      optimal needed force
     * @param organisationType type of emergency
     * @param address          address of this event
     * @param status           status of beginning
     * @param endTime          fix end for operation
     */
    public Operation(String title, Date startTime, int neededForce, OrganisationType organisationType, Address address, Status status, Date endTime) {
        this(title, startTime, neededForce, organisationType, address, status);
        this.endTime = endTime;
    }

    /**
     * advanced operation with status as extra
     *
     * @param title            readable for user
     * @param startTime        time operation started (maybe now)
     * @param neededForce      optimal needed force
     * @param organisationType type of emergency
     * @param address          address of this event
     * @param status           status of beginning
     */
    public Operation(String title, Date startTime, int neededForce, OrganisationType organisationType, Address address, Status status) {
        this(title, startTime, neededForce, organisationType, address);
        this.status = status;
    }

    /**
     * Create standard operation
     *
     * @param title            readable for user
     * @param startTime        time operation started (maybe now)
     * @param neededForce      optimal needed force
     * @param organisationType type of emergency
     * @param address          address of this event
     * @see OrganisationType
     */
    public Operation(@NotNull String title, Date startTime, int neededForce, OrganisationType organisationType, Address address) {
        this.title = title;
        this.startTime = startTime;
        this.neededForce = neededForce;
        this.organisationType = organisationType;
        this.address = address;
        maxProgress = 10000;
        this.status = Status.open;
    }


    //Getter

    /**
     * @return title of this operation //TODO: maybe minimal description?
     */
    @NotNull
    public String getTitle() {
        return title;
    }

    /**
     * @return address of this operation
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @return startTime of this operation
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @return endTime of this operation //TODO: calculated?
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @return actual operation status
     * @see Status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @return optimal needed workForce
     */
    public double getNeededForce() {
        return neededForce;
    }

    /**
     * @return actual progress
     */
    public double getProgress() {
        return (int) progress;
    }

    /**
     * @return max reachable progress
     */
    public double getMaxProgress() {
        return maxProgress;
    }

    //Setter

    /**
     * Add progress, but only if not == maxProgress, set status to success
     *
     * @param progress value to add
     */
    private void addProgress(double progress) {
        if (status == Status.inProgress)
            if (progress + this.progress < getMaxProgress())
                this.progress += progress;
            else {
                this.progress = maxProgress;
                status = Status.success;
            }
    }

    //Methods

    /**
     * call, if workForce do some work at this operation
     *
     * @param workForce working workForce
     */
    public void work(WorkForce workForce) {
        if (workForce.getEmergencyType() == organisationType) {
            if (status == Status.open)
                status = Status.inProgress;
            addProgress((workForce.getForce() / neededForce) * 100);
        }
    }

}

