package tests;

import java.util.*;

import search.DepthFirstSearch;
import search.HillClimbing;
import search.BestFirst;
import data.ReadFileCSV;

public class prueba {

    public static void main(String[] args) {
        
        //ReadFileCSV distancias = new ReadFileCSV("distancias.csv");
        //ReadFileCSV nodos = new ReadFileCSV("nodos.csv");
        
        /*
        DepthFirstSearch dfs = new DepthFirstSearch(nodos.getData());
        dfs.search(1, 18, "horario");
        System.out.println(dfs.getSteps());
        System.out.println(dfs.getRute(18));
        */
        /*
        HillClimbing hc = new HillClimbing(nodos.getData(), distancias.getData());
        hc.search(1, 18, "horario");
        System.out.println(hc.getSteps());
        System.out.println(hc.getRute());
        */
        /*
        BestFirst bf = new BestFirst(nodos.getData(), distancias.getData());
        
        bf.search(1, 18, "antihorario");
        System.out.println(bf.getSteps());
        System.out.println(bf.getRute());
        */
    }
 
}

