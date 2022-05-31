package tests;

import java.util.*;

import data.Nodes;
import search.DFS;


public class prueba {

    public static void main(String[] args) {
        Nodes nodes_n = new Nodes();
        ArrayList<List<Integer>> nodes = nodes_n.getNodes();
                
        DFS d = new DFS();
        d.DepthFirstSearch(8,18, "horario");
        
        System.out.println(d.getSteps());
        
        
    }    
}
