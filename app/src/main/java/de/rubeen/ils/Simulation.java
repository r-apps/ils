package de.rubeen.ils;

import java.util.ArrayList;
import java.util.Date;

import de.rubeen.ils.enums.EmergencyType;

/**
 * Created by rubeen on 05.06.17.
 */

public class Simulation {

    private static Simulation instance;

    private ArrayList<Operation> listOperation;


    public Simulation(SimulationParams simulationParams) {
        //Initialisations
        createMaps();
        instance = this;

        if (simulationParams.isDEBUG)
            fillLists();
    }

    public static Simulation getInstance() {
        return instance;
    }

    public ArrayList<Operation> getOperations() {
        return listOperation;
    }

    private void fillLists() {
        listOperation.add(new Operation("Car accident", new Date(), 40, EmergencyType.crash, new Address("Braunschweiger Straße 35", "38259", "Salzgitter")));
        listOperation.add(new Operation("Tree in fire", new Date(), 80, EmergencyType.fire, new Address("Gartenstraße 36", "38229", "Salzgitter")));
        listOperation.add(new Operation("Heart attack", new Date(), 100, EmergencyType.ambulance, new Address("Hinter den Wiesen 80a", "38259", "Salzgitter")));
        listOperation.add(new Operation("Apoplexy", new Date(), 120, EmergencyType.ambulance, new Address("Unter den Buchen 3", "38259", "Salzgitter")));
        listOperation.add(new Operation("Fallen tree", new Date(), 30, EmergencyType.technic, new Address("Zur Himmelstüre 35", "11111", "Himmelspforte")));
        listOperation.add(new Operation("Thief", new Date(), 30, EmergencyType.police, new Address("Erikastraße 11", "38259", "Salzgitter")));

        for (int i = 0; i < listOperation.size(); i++) {
            for (int j = 0; j < (i * 10); j++) {
                listOperation.get(i).work(new WorkForce(EmergencyType.ambulance, 50));
                listOperation.get(i).work(new WorkForce(EmergencyType.crash, 50));
                listOperation.get(i).work(new WorkForce(EmergencyType.fire, 50));
                listOperation.get(i).work(new WorkForce(EmergencyType.police, 50));
                listOperation.get(i).work(new WorkForce(EmergencyType.technic, 50));
            }
            System.out.println(String.format("[PROGRESS] %s von %s", String.valueOf(listOperation.get(i).getProgress()), String.valueOf(listOperation.get(i).getMaxProgress())));
        }
    }

    private void createMaps() {
        listOperation = new ArrayList<>();
    }
}

