package framework.solution;

import framework.graph.Vertex;
import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.LinkedList;

/* imports go here */

/**
 * This class represents a state space solver by extending the abstract
 * Solver class.
 * @author Your name and section here
 */
public class StateSpaceSolver extends Solver {
    
    /**
     * Creates a BFS or DFS state space solver.
     * This constructor should set the queue to a double-ended queue (DEQUE)
     * and set the statistics header.
     * @param problem the problem being solved
     * @param bfs a boolean flag indicating whether BFS is to be performed
     */
    public StateSpaceSolver(Problem problem, boolean bfs) {
        super(problem);
        this.bfs = bfs;
        mover = problem.getMover();
        deque = new LinkedList<>();
        super.setQueue(deque);      
    }
    
    /**
     * Adds a vertex to the DEQUE.
     * If BFS is being performed, the vertex should be added to the
     * end of the DEQUE, so the DEQUE acts like an ordinary queue.
     * If DFS is being performed, the vertex should be added to the
     * front of the DEQUE, so the DEQUE acts like a stack.
     * @param v 
     */
    @Override
    public void add(Vertex v) {
	if (bfs) {
            deque.addLast(v);
        } else {
            deque.addFirst(v);
        }
    }
    
    /**
     * This method implements the expand operation required by the 
     * state space search algorithm:

       Expand(u)
          children = {}
          for each name âˆˆ moveNames do
             child = mover.doMove(name, u)
             if child â‰  null and not OccursOnPath(child, u)
                then d[child] = d[u] + 1
                     pred[child] = u
                     add child to children
          return children

     * @param u the vertex being expanded
     * @return 
     */
    @Override
    public List<Vertex> expand(Vertex u) {
        List<Vertex> children = new ArrayList<>();
        List<String> moveNames = mover.getMoveNames();
        State state;
        Vertex child;
   
          for (String name : moveNames) {
             state = mover.doMove(name, (State)u.getData());
             child = new Vertex(state);
             if (state !=  null && !occursOnPath(child, u)) {                 
                 child.setDistance(u.getDistance() + 1);
                 child.setPredecessor(u);
                 children.add(child);
                 }
          }
          
        return children;
    }

    /**
     * Checks whether a given vertex appears on the predecessor path
     * of a given ancestor.
     * @param v the vertex to check
     * @param ancestor the ancestor vertex of v
     * @return true if v occurs on the predecessor path of ancestor,
     * false otherwise
     */
    public static boolean occursOnPath(Vertex v, Vertex ancestor) {
        boolean onPath = false;
        Vertex currVertex;
	currVertex = ancestor.getPredecessor();
        
        if (v.equals(ancestor)) {
            return true;
        }
        while (currVertex != null) {
            if (v.equals(currVertex)) {
            onPath = true;
            }
            currVertex = currVertex.getPredecessor();
        }
        return onPath;    
    }
    
    private Mover mover;  
    private Deque<Vertex> deque;
    private boolean bfs;
   
}