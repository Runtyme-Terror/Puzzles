/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;

import framework.ui.ProblemGUI;

/**
 *
 * @author David Gagliardi
 */
public class FarmerGUI {

    private ProblemGUI problemGUI;

    public FarmerGUI() {
        problemGUI = new ProblemGUI(new FarmerProblem(), 750, 875);
    }
    
    public ProblemGUI getProblemGUI(){
        return problemGUI;
    }
}