/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.dummy;

import framework.ui.ProblemGUI;

/**
 *
 * @author David Gagliardi
 */
public class DummyGUI {

    private ProblemGUI problemGUI;

    public DummyGUI() {
        problemGUI = new ProblemGUI(new DummyProblem(), 750, 875);
    }
    
    public ProblemGUI getProblemGUI(){
        return problemGUI;
    }
}