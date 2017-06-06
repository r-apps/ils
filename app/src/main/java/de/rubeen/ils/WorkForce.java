package de.rubeen.ils;


import de.rubeen.ils.enums.OrganisationType;

/**
 * Created by rubeen on 05.06.17.
 *
 * instance of a workForce
 */

class WorkForce {
    private final OrganisationType type;
    private int force;
    private Operation actualOperation;


    /**
     * create a standard workForce object with predefined operation
     *
     * @param type      of organisation this wF is working for
     * @param force     aka. strength
     * @param operation as initial operation
     */
    public WorkForce(OrganisationType type, int force, Operation operation) {
        this(type, force);
        this.actualOperation = operation;
    }

    /**
     * Create a standard workForce object
     *
     * @param type  of organisation this workForce is working for
     * @param force aka. strength
     */
    public WorkForce(OrganisationType type, int force) {
        this.type = type;
        this.force = force;
    }

    //Getter
    public OrganisationType getEmergencyType() {
        return type;
    }

    /**
     *
     * @return the force witch this workForce works with
     */
    public int getForce() {
        return force;
    }

    /**
     *
     * @param actualOperation for workForce to work for
     */
    public void setActualOperation(Operation actualOperation) {
        this.actualOperation = actualOperation;
    }
}
