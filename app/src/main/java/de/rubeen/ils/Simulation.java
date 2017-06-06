package de.rubeen.ils;

import java.util.ArrayList;
import java.util.Date;

import de.rubeen.ils.enums.OrganisationType;

/**
 * Created by rubeen on 05.06.17.
 * <p>
 * Simulation class, like GameObject
 */

public class Simulation {

    private static Simulation instance;

    private ArrayList<Operation> listOperation;


    public Simulation(SimulationParams simulationParams) {
        //Initialisations
        createLists();
        instance = this;

        //DEBUG
        if (simulationParams.isDEBUG)
            fillLists();
    }

    /**
     * @return the one (and only, please!) instance of a simulation object
     */
    public static Simulation getInstance() {
        return instance;
    }

    /**
     * @return list of operations //TODO: active operations
     */
    public ArrayList<Operation> getOperations() {
        return listOperation;
    }

    /**
     * Fill lists // only when DEBUG //TODO: better with mocks, but how :(
     */
    private void fillLists() {
        listOperation.add(new Operation("Car accident", new Date(), 40, OrganisationType.crash, new Address("Street 1", "38259", "City 1")));
        listOperation.add(new Operation("Tree in fire", new Date(), 80, OrganisationType.fire, new Address("Street 2", "38229", "City 2")));
        listOperation.add(new Operation("Heart attack", new Date(), 100, OrganisationType.ambulance, new Address("Street 3", "38259", "City 3")));
        listOperation.add(new Operation("Apoplexy", new Date(), 120, OrganisationType.ambulance, new Address("Street 4", "38259", "City 4")));
        listOperation.add(new Operation("Fallen tree", new Date(), 30, OrganisationType.tech, new Address("Street 5", "11111", "City 5")));
        listOperation.add(new Operation("Thief", new Date(), 30, OrganisationType.police, new Address("Street 6", "38259", "City 6")));

        for (int i = 0; i < listOperation.size(); i++) {
            for (int j = 0; j < (i * 10); j++) {
                listOperation.get(i).work(new WorkForce(OrganisationType.ambulance, 50));
                listOperation.get(i).work(new WorkForce(OrganisationType.crash, 50));
                listOperation.get(i).work(new WorkForce(OrganisationType.fire, 50));
                listOperation.get(i).work(new WorkForce(OrganisationType.police, 50));
                listOperation.get(i).work(new WorkForce(OrganisationType.tech, 50));
            }
            System.out.println(String.format("[PROGRESS] %s von %s", String.valueOf(listOperation.get(i).getProgress()), String.valueOf(listOperation.get(i).getMaxProgress())));
        }
    }

    /**
     * Create lists, & maps
     */
    private void createLists() {
        listOperation = new ArrayList<>();
    }
}

