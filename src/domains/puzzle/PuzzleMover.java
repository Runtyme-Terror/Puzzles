package domains.puzzle;
/**
 * CS 2511
 * @author David Gagliardi
 */

import domains.puzzle.PuzzleState.Location;
import framework.problem.Mover;
import framework.problem.State;

public class PuzzleMover extends Mover {
    
    public PuzzleMover() {
        super.addMove(slide1, s -> trySlide1(s));
        super.addMove(slide2, s -> trySlide2(s));
        super.addMove(slide3, s -> trySlide3(s));
        super.addMove(slide4, s -> trySlide4(s));
        super.addMove(slide5, s -> trySlide5(s));
        super.addMove(slide6, s -> trySlide6(s));
        super.addMove(slide7, s -> trySlide7(s));
        super.addMove(slide8, s -> trySlide8(s));
    }
    
    
    private State trySlide1 (State state) {
        PuzzleState oldState = (PuzzleState) state;
        Location currTile = oldState.getLocation(1);
        Location blankTile = oldState.getLocation(0);
        
        if (validMove(currTile, blankTile)) {
            return new PuzzleState(oldState, currTile, blankTile);
        } else {
            return null;
        }
    }
    
    private State trySlide2 (State state) {
        PuzzleState oldState = (PuzzleState) state;
        Location currTile = oldState.getLocation(2);
        Location blankTile = oldState.getLocation(0);
        
        if (validMove(currTile, blankTile)) {
            return new PuzzleState(oldState, currTile, blankTile);
        } else {
            return null;
        }
    }
    
    private State trySlide3 (State state) {
        PuzzleState oldState = (PuzzleState) state;
        Location currTile = oldState.getLocation(3);
        Location blankTile = oldState.getLocation(0);
        
        if (validMove(currTile, blankTile)) {
            return new PuzzleState(oldState, currTile, blankTile);
        } else {
            return null;
        }
    }
    
    private State trySlide4 (State state) {
        PuzzleState oldState = (PuzzleState) state;
        Location currTile = oldState.getLocation(4);
        Location blankTile = oldState.getLocation(0);
        
        if (validMove(currTile, blankTile)) {
            return new PuzzleState(oldState, currTile, blankTile);
        } else {
            return null;
        }
    }
    
    private State trySlide5 (State state) {
        PuzzleState oldState = (PuzzleState) state;
        Location currTile = oldState.getLocation(5);
        Location blankTile = oldState.getLocation(0);
        
        if (validMove(currTile, blankTile)) {
            return new PuzzleState(oldState, currTile, blankTile);
        } else {
            return null;
        }
    }
    
    private State trySlide6 (State state) {
        PuzzleState oldState = (PuzzleState) state;
        Location currTile = oldState.getLocation(6);
        Location blankTile = oldState.getLocation(0);

if (validMove(currTile, blankTile)) {
            return new PuzzleState(oldState, currTile, blankTile);
        } else {
            return null;
        }        
    }
    
    private State trySlide7 (State state) {
        PuzzleState oldState = (PuzzleState) state;
        Location currTile = oldState.getLocation(7);
        Location blankTile = oldState.getLocation(0); 
        
        if (validMove(currTile, blankTile)) {
            return new PuzzleState(oldState, currTile, blankTile);
        } else {
            return null;
        }
    }
    
    private State trySlide8 (State state) {
        PuzzleState oldState = (PuzzleState) state;
        Location currTile = oldState.getLocation(8);
        Location blankTile = oldState.getLocation(0); 
        
        if (validMove(currTile, blankTile)) {
            return new PuzzleState(oldState, currTile, blankTile);
        } else {
            return null;
        }
    }
    
    private boolean validMove(Location tile, Location blank) {
        boolean valid = false;
        
        if (((tile.getColumn() - 1 == blank.getColumn()
                || tile.getColumn() + 1 == blank.getColumn())
                && (tile.getRow() == blank.getRow()))
                || ((tile.getRow() - 1 == blank.getRow()
                || tile.getRow() + 1 == blank.getRow())
                && tile.getColumn() == blank.getColumn())) {
            valid = true;
        }
        
        return valid;
    }
    
    public static String slide1 = "Slide Tile 1";
    public static String slide2 = "Slide Tile 2";
    public static String slide3 = "Slide Tile 3";
    public static String slide4 = "Slide Tile 4";
    public static String slide5 = "Slide Tile 5";
    public static String slide6 = "Slide Tile 6";
    public static String slide7 = "Slide Tile 7";
    public static String slide8 = "Slide Tile 8";
}

