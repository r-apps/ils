package de.rubeen.ils;

import java.util.TreeMap;

/**
 * Created by rubeen on 05.06.17.
 */

public class Simulation {

    private TreeMap<Integer, Operation> mapOperation;

    public Simulation(Params params) {
        //Initialisations
        createMaps();

        if (params.isDEBUG)
            fillMaps();
    }

    private void fillMaps() {

    }

    private void createMaps() {
        mapOperation = new TreeMap<>();
    }

    class Params {
        protected final boolean isDEBUG;

        public Params(boolean isDEBUG) {
            this.isDEBUG = isDEBUG;
        }
    }
}
