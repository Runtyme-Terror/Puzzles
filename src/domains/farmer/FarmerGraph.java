package domains.farmer;

import framework.graph.Graph;
import framework.graph.Vertex;

/**
 * A graph for the FWGC problem.
 * 
 * CS 2511
 * @author David Gagliardi
 */
public class FarmerGraph extends Graph {
    
    public FarmerGraph() {
        farmVertex1 = new Vertex(new FarmerState("West",
                                                "West",
                                                "West",
                                                "West"));
        farmVertex7 = new Vertex(new FarmerState("East",
                                                "West",
                                                "East",
                                                "West"));
        farmVertex4 = new Vertex(new FarmerState("West",
                                                "West",
                                                "East",
                                                "West"));
        farmVertex10 = new Vertex(new FarmerState("East",
                                                "East",
                                                "East",
                                                "West"));
        farmVertex8 = new Vertex(new FarmerState("East",
                                                "West",
                                                "East",
                                                "East"));
        farmVertex3 = new Vertex(new FarmerState("West",
                                                "East",
                                                "West",
                                                "West"));
        farmVertex5 = new Vertex(new FarmerState("West",
                                                "West",
                                                "West",
                                                "East"));
        farmVertex9 = new Vertex(new FarmerState("East",
                                                "East",
                                                "West",
                                                "East"));
        farmVertex2 = new Vertex(new FarmerState("West",
                                                "East",
                                                "West",
                                                "East"));
        farmVertex6 = new Vertex(new FarmerState("East",
                                                  "East",
                                                  "East",
                                                  "East"));
        addEdge(farmVertex1, farmVertex7);
        addEdge(farmVertex7, farmVertex1);
        addEdge(farmVertex7, farmVertex4);
        addEdge(farmVertex4, farmVertex7);
        addEdge(farmVertex4, farmVertex10);
        addEdge(farmVertex10, farmVertex4);
        addEdge(farmVertex4, farmVertex8);
        addEdge(farmVertex8, farmVertex4);
        addEdge(farmVertex10, farmVertex3);
        addEdge(farmVertex3, farmVertex10);
        addEdge(farmVertex8, farmVertex5);
        addEdge(farmVertex5, farmVertex8);
        addEdge(farmVertex3, farmVertex9);
        addEdge(farmVertex9, farmVertex3);
        addEdge(farmVertex5, farmVertex9);
        addEdge(farmVertex9, farmVertex5);
        addEdge(farmVertex9, farmVertex2);
        addEdge(farmVertex2, farmVertex9);
        addEdge(farmVertex2, farmVertex6);
        addEdge(farmVertex6, farmVertex2);
    }
    
    public Vertex getStart() {
        return farmVertex1;
    }
    
    public Vertex getEnd() {
        return farmVertex6;
    }
    
    Vertex farmVertex1;
    Vertex farmVertex2;
    Vertex farmVertex3;
    Vertex farmVertex4;
    Vertex farmVertex5;
    Vertex farmVertex6;
    Vertex farmVertex7;
    Vertex farmVertex8;
    Vertex farmVertex9;
    Vertex farmVertex10;    
}
