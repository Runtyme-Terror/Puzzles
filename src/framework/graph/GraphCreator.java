package framework.graph;

import domains.farmer.FarmerMover;
import domains.farmer.FarmerState;
import domains.puzzle.PuzzleMover;
import domains.puzzle.PuzzleState;
import framework.problem.Problem;
import framework.problem.State;
import java.util.List;
import java.util.Stack;

/**
 * CS 2511
 * @author David Gagliardi
 */
public class GraphCreator {
    
    public Graph createGraphFor(Problem problem) {
        graph = new Graph();
        stack = new Stack<>(); 
        farmerMover = new FarmerMover();
        puzzleMover = new PuzzleMover();       
        

        if ("Farmer, Wolf, Goat, and Cabbage".equals(problem.getName())) {
        
        
        start = new Vertex(new FarmerState("West",
                                           "West",
                                           "West",
                                           "West"));
        
        stack.push(start);
        moveNames = farmerMover.getMoveNames();
        
        while (!stack.isEmpty()) {
            u = (Vertex)stack.pop();  
            for (int m = 0; m <= 3; m++) {
                next = farmerMover.doMove(moveNames.get(m), (State)u.getData());
                if (next != null){
                    v = new Vertex(next);
                    if (graph.getVertices().containsKey(v)) {
                        v = graph.getVertices().get(v);
                    } else {
                        stack.push(v);                        
                    }                    
                    graph.addEdge(u, v);
                }
            }
        }
        } else if ("8-Puzzle".equals(problem.getName())) {
            
        int[][] tiles = new int[3][3];
                
        tiles[0][0] = 2;
        tiles[0][1] = 8;
        tiles[0][2] = 3;
        tiles[1][0] = 1;
        tiles[1][1] = 6;
        tiles[1][2] = 4;
        tiles[2][0] = 7;
        tiles[2][1] = 0;
        tiles[2][2] = 5;
            
        start = new Vertex(new PuzzleState(tiles));
        
        stack.push(start);
        moveNames = puzzleMover.getMoveNames();
        
        while (!stack.isEmpty()) {
            u = (Vertex)stack.pop();  
            for (int m = 0; m <= 7; m++) {
                next = puzzleMover.doMove(moveNames.get(m), (State)u.getData());
                if (next != null){
                    v = new Vertex(next);
                    if (graph.getVertices().containsKey(v)) {
                        v = graph.getVertices().get(v);
                    } else {
                        stack.push(v);                        
                    }                    
                    graph.addEdge(u, v);
                }
            }
        }
            
        }
        return graph;
    }
    
    private FarmerMover farmerMover;
    private PuzzleMover puzzleMover;
    private State next;
    private Vertex start;
    private Vertex u;
    private Vertex v;
    private Graph graph = null;
    private Stack stack = null;
    private List<String> moveNames;
}