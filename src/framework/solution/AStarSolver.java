package framework.solution;

/* imports go here */
import framework.graph.Vertex;
import framework.problem.Problem;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * This class represents an A* solver by extending the StateSpaceSolver
 * class.
 * @author David Gagliardi
 */
public class AStarSolver extends StateSpaceSolver {
    
    /**
     * Creates an A* solver.
     * This constructor should set the queue to a priority queue (PQ)
     * and set the statistics header.
     * @param problem 
     */
    public AStarSolver(Problem problem) {
        super(problem, false);
        pQueue = new PriorityQueue<>(10, getComparator());
        /* you must provide */
    }
    
    /**
     * Adds a vertex to the PQ.
     * @param v the vertex to be added
     */
    @Override
    public void add(Vertex v) {
        pQueue.add(v);
    }
    
    /**
     * Creates a comparator object that compares vertices for ordering
     * in a PQ during A* search.
     * This should be used when creating the PQ.
     * @return the comparator object
     */
    public final Comparator<Vertex> getComparator() {
        Comparator<Vertex> comparator = (Vertex v1, Vertex v2) -> {
            if (v1.getDistance() > v2.getDistance()){
                return +1;
            }else if (v1.getDistance() < v2.getDistance()){
                return -1;
            }else {
                return 0;
            }
        };
        
        return comparator;
    }
    PriorityQueue<Vertex> pQueue;
}