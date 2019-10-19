package domains.puzzle;

/**
 * CS 2511
 * @author David Gagliardi
 */

import framework.problem.Problem;
import framework.problem.Benchmark;

public final class PuzzleProblem extends Problem {
        
    public PuzzleProblem() {
        super();
        super.setName("8-Puzzle");
        super.setIntroduction(INTRO);
        super.setMover(new PuzzleMover());
        super.setInitialState(new PuzzleState(createInitialTiles()));
        super.setCurrentState(super.getInitialState());
        super.setFinalState(new PuzzleState(createFinalTiles()));
    }
    
    public int[][] createInitialTiles() {
        int[][] start = new int[3][3];
                
        start[0][0] = 2;
        start[0][1] = 8;
        start[0][2] = 3;
        start[1][0] = 1;
        start[1][1] = 6;
        start[1][2] = 4;
        start[2][0] = 7;
        start[2][1] = 0;
        start[2][2] = 5;
        
        return start;
    }
    
    public int[][] createFinalTiles() {
        int[][] end = new int[3][3];
        
        end[0][0] = 1;
        end[0][1] = 2;
        end[0][2] = 3;
        end[1][0] = 8;
        end[1][1] = 0;
        end[1][2] = 4;
        end[2][0] = 7;
        end[2][1] = 6;
        end[2][2] = 5;
        
        return end;
    }
    

    private static final String INTRO =             
            "Welcome to the 8-Puzzle problem. In this problem you will " +
            "attempt to arrange the numbered tiles as follows\n" +
            "+---+---+---+\n" +
            "| 1 | 2 | 3 |\n" +
            "+---+---+---+\n" +
            "| 8 |   | 4 |\n" +
            "+---+---+---+\n" +
            "| 7 | 6 | 5 |\n" +
            "+---+---+---+\n\n"
          + "Good luck!";
}
