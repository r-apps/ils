package de.rubeen.ils;


import de.rubeen.ils.enums.EmergencyType;

/**
 * Created by rubeen on 05.06.17.
 */

class WorkForce {
    private EmergencyType type;
    private int force;

    public WorkForce(EmergencyType type, int force) {
        this.type = type;
        this.force = force;
    }

    //Getter
    public EmergencyType getEmergencyType() {
        return type;
    }

    public int getForce() {
        return force;
    }

}
