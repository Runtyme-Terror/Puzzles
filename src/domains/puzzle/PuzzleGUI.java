/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.puzzle;

import framework.ui.ProblemGUI;

/**
 *
 * @author David Gagliardi
 */
public class PuzzleGUI {

    private ProblemGUI problemGUI;

    public PuzzleGUI() {
        problemGUI = new ProblemGUI(new PuzzleProblem(), 750, 875);
    }
    
    public ProblemGUI getProblemGUI(){
        return problemGUI;
    }
}