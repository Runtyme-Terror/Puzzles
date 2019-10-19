/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.arithmetic;

import framework.ui.ProblemGUI;

/**
 *
 * @author David Gagliardi
 */
public class ArithmeticGUI {

    private final ProblemGUI problemGUI;

    public ArithmeticGUI() {
        problemGUI = new ProblemGUI(new ArithmeticProblem(), 750, 875);
    }
    
    public ProblemGUI getProblemGUI(){
        return problemGUI;
    }
}