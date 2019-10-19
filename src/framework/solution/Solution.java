package framework.solution;
import java.util.Stack;
import framework.graph.Vertex;

/**
 * CS 2511
 * @author David Gagliardi
 */
public class Solution {

    /**
     * Creates an object that represents a path from a start
     * vertex to an end vertex in a problem solving domain.
     * This constructor will be called after a search has been
     * initiated on the start vertex.
     * If a path from start to end exists, it can be constructed
     * from the predecessor information stored in the end vertex.
     * @param start the start vertex
     * @param end the end vertex
     */
    public Solution(Vertex start, Vertex end) {
        startVertex = start;
        endVertex = end;
        solutionStack = new Stack<>();
        length = 0;
        
        currVertex = endVertex;
        
        while (currVertex.getPredecessor() != null) {
            solutionStack.push(currVertex);
            currVertex = currVertex.getPredecessor();   
            ++length;
        } 
        
        solutionStack.push(currVertex);
    }

    /**
     * Gets the length of the solution, that is, the number of moves
     * to get to the end state from the start.
     * @return the solution length
     */
    public int getLength() {
        return length;
    }
    
    /**
     * Checks whether there are more vertices in this solution.
     * @return true if there are more vertices in this solution, false
     * otherwise
     */
    public boolean hasNext() {
        return !solutionStack.empty();
    }
    
    /**
     * Removes and returns the next vertex in this solution.
     * @return the next vertex in this solution
     * @throws RuntimeException if there are no more vertices
     */
    public Vertex next() {
        if (hasNext()) {
            
            try {
            nextVertex = (Vertex) solutionStack.peek();
            solutionStack.pop();
            }
            catch (RuntimeException e) {
                System.out.println("Attempted to pop an empty stack!");
            }
        }
        
        return nextVertex;
    }
    
    private final Vertex startVertex;
    private final Vertex endVertex;
    private Vertex currVertex;
    private Vertex nextVertex;
    private int length;
    private Stack solutionStack;
}