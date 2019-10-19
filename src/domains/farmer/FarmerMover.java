package domains.farmer;
/**
 * CS 2511
 * @author David Gagliardi
 */

import framework.problem.Mover;
import framework.problem.State;

public class FarmerMover extends Mover {
    
    public FarmerMover() {
        super.addMove(goesAlone, s -> tryAlone(s));
        super.addMove(takesWolf, s -> tryWolf(s));
        super.addMove(takesGoat, s -> tryGoat(s));
        super.addMove(takesCabbage, s -> tryCabbage(s));
    }
    
    
    private State tryAlone(State state) {
        FarmerState oldState = (FarmerState) state;
        
        FarmerState safeState1 = new FarmerState("East",
                                                 "East",
                                                 "West",
                                                 "East");
        
        FarmerState safeState2 = new FarmerState("West",
                                                 "East",
                                                 "West",
                                                 "East");
        
        FarmerState safeState3 = new FarmerState("East",
                                                 "West",
                                                 "East",
                                                 "West");
        
        FarmerState safeState4 = new FarmerState("West",
                                                 "West",
                                                 "East",
                                                 "West");
        if (oldState.equals(safeState1)) {
            return safeState2;
        } else if (oldState.equals(safeState2)) {
            return safeState1;
        } else if (oldState.equals(safeState3)) {
            return safeState4;
        } else if (oldState.equals(safeState4)) {
            return safeState3;
        } else {
            return null;
        }
    }
    
    private State tryWolf(State state) {
        FarmerState oldState = (FarmerState) state;
        
        FarmerState safeState1 = new FarmerState   ("West",
                                                    "West",
                                                    "East",
                                                    "West");
        
        FarmerState safeState2 = new FarmerState   ("West",
                                                    "West",
                                                    "West",
                                                    "East");

        FarmerState safeState3 = new FarmerState   ("East",
                                                    "East",
                                                    "West",
                                                    "East");
        
        FarmerState safeState4 = new FarmerState   ("East",
                                                    "East",
                                                    "East",
                                                    "West");        
        
        if (oldState.equals(safeState1)) {
            return safeState4;
        } else if (oldState.equals(safeState2)) {
            return safeState3;
        } else if (oldState.equals(safeState3)) {
            return safeState2;
        } else if (oldState.equals(safeState4)) {
            return safeState1;
        } else {
            return null;
        }      
    }
    
    private State tryGoat(State state) {
        FarmerState oldState = (FarmerState) state;
        
        FarmerState safeState1 = new FarmerState   ("West",
                                                    "West",
                                                    "West",
                                                    "West");
        
        FarmerState safeState2 = new FarmerState   ("East",
                                                    "West",
                                                    "East",
                                                    "West");
        
        FarmerState safeState3 = new FarmerState   ("West",
                                                    "West",
                                                    "West",
                                                    "East");
        
        FarmerState safeState4 = new FarmerState   ("East",
                                                    "East",
                                                    "East",
                                                    "West");        
        
        FarmerState safeState5 = new FarmerState   ("West",
                                                    "East",
                                                    "West",
                                                    "West");
        
        FarmerState safeState6 = new FarmerState   ("East",
                                                    "West",
                                                    "East",
                                                    "East");
        
        FarmerState safeState7 = new FarmerState   ("West",
                                                    "East",
                                                    "West",
                                                    "East");
        
        FarmerState safeState8 = new FarmerState   ("East",
                                                    "East",
                                                    "East",
                                                    "East");
        
        
        
        if (oldState.equals(safeState1)) {
            return safeState2;
        } else if (oldState.equals(safeState2)) {
            return safeState1;
        } else if (oldState.equals(safeState3)) {
            return safeState6;
        } else if (oldState.equals(safeState8)) {
            return safeState7;
        } else if (oldState.equals(safeState4)) {
            return safeState5;
        } else if (oldState.equals(safeState5)) {
            return safeState4;
        } else if (oldState.equals(safeState6)) {
            return safeState3;
        } else if (oldState.equals(safeState7)) {
            return new FarmerState ("East", "East", "East", "East");
        } else {
            return null;            
        }
        
        
    }
    
    private State tryCabbage(State state) {
        FarmerState oldState = (FarmerState) state;
        
        FarmerState safeState1 = new FarmerState   ("West",
                                                    "West",
                                                    "East",
                                                    "West");
        
        FarmerState safeState2 = new FarmerState   ("East",
                                                    "East",
                                                    "West",
                                                    "East");
        
        FarmerState safeState3 = new FarmerState   ("West",
                                                    "East",
                                                    "West",
                                                    "West");
        
        FarmerState safeState4 = new FarmerState   ("East",
                                                    "West",
                                                    "East",
                                                    "East");
        
        
        
        if (oldState.equals(safeState1)) {
            return safeState4;
        } else if (oldState.equals(safeState2)) {
            return safeState3;
        } else if (oldState.equals(safeState3)) {
            return safeState2;
        } else if (oldState.equals(safeState4)) {
            return safeState1;
        } else {
            return null;
        }
        
    }
    
    public static String goesAlone = "Farmer goes alone.";
    public static String takesWolf = "Farmer takes wolf.";
    public static String takesGoat = "Farmer takes goat.";
    public static String takesCabbage = "Farmer takes cabbage.";
}

