/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.problem;

/**
 *
 * @author David Gagliardi
 */
public class Benchmark {
    String name;
    State start;
    State goal;
    
    
    public Benchmark(String name, State start, State goal) {
        this.name = name;
        this.start = start;
        this.goal = goal;   
        
    }
    
    public State getStart() {
        return start;
    }
    
    public State getGoal() {
        return goal;
    }
    
    @Override
    public String toString() {
        return name;
    }

}
