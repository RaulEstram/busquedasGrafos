package tests;

import java.util.*;

import search.DepthFirstSearch;
import search.HillClimbing;
import data.ReadFileCSV;

public class prueba {

    public static void main(String[] args) {
        
        ReadFileCSV distancias = new ReadFileCSV("distancias.csv");
        ReadFileCSV nodos = new ReadFileCSV("nodos.csv");
        
        //DepthFirstSearch dfs = new DepthFirstSearch(nodos.getData());
        //dfs.search(8, 18, "antihorario");

        //System.out.println(dfs.getSteps());
        //System.out.println(dfs.getRute(18));
        
        HillClimbing hc = new HillClimbing(nodos.getData(), distancias.getData());
        hc.search(8, 18, "antihorario");
        System.out.println(hc.getSteps());
        System.out.println(hc.getRute());

    }
}
