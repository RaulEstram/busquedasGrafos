package data;

import java.util.*;

public class Nodes {
    
    private final ArrayList<List<Integer>> Nodes = new ArrayList<>();
    
    public Nodes() {
        for (int i = 0; i < 28; i++) {
            this.Nodes.add(new ArrayList<>());
        }
        
        for (int i = 0; i < (this.Nodes.size()) ; i++) {
            this.Nodes.get(i).add(i + 1);
        }
        
        this.Nodes.get(0).add(6);
        this.Nodes.get(0).add(13);
        this.Nodes.get(0).add(4);

        this.Nodes.get(1).add(22);
        this.Nodes.get(1).add(12);
        this.Nodes.get(1).add(9);

        this.Nodes.get(2).add(14);
        this.Nodes.get(2).add(23);
        this.Nodes.get(2).add(19);
        this.Nodes.get(2).add(18);
        
        this.Nodes.get(3).add(9);
        this.Nodes.get(3).add(1);
        this.Nodes.get(3).add(13);
        
        this.Nodes.get(4).add(15);
        this.Nodes.get(4).add(11);
        
        this.Nodes.get(5).add(16);
        this.Nodes.get(5).add(1);
        
        this.Nodes.get(6).add(27);
        this.Nodes.get(6).add(8);
        this.Nodes.get(6).add(11);
        
        this.Nodes.get(7).add(27);
        this.Nodes.get(7).add(15);
        this.Nodes.get(7).add(7);
        
        this.Nodes.get(8).add(28);
        this.Nodes.get(8).add(2);
        this.Nodes.get(8).add(17);
        this.Nodes.get(8).add(4);
        this.Nodes.get(8).add(24);
        
        this.Nodes.get(9).add(16);
        this.Nodes.get(9).add(12);
        
        this.Nodes.get(10).add(7);
        this.Nodes.get(10).add(5);
        
        this.Nodes.get(11).add(10);
        this.Nodes.get(11).add(2);
        
        this.Nodes.get(12).add(4);
        this.Nodes.get(12).add(1);
        this.Nodes.get(12).add(24);
        
        this.Nodes.get(13).add(23);
        this.Nodes.get(13).add(3);
        
        this.Nodes.get(14).add(8);
        this.Nodes.get(14).add(24);
        this.Nodes.get(14).add(5);
        
        this.Nodes.get(15).add(19);
        this.Nodes.get(15).add(25);
        this.Nodes.get(15).add(20);
        this.Nodes.get(15).add(6);
        this.Nodes.get(15).add(26);
        this.Nodes.get(15).add(10);
        
        this.Nodes.get(16).add(26);
        this.Nodes.get(16).add(9);
        
        this.Nodes.get(17).add(14);
        this.Nodes.get(17).add(3);
        this.Nodes.get(17).add(21);
        
        this.Nodes.get(18).add(23);
        this.Nodes.get(18).add(16);
        this.Nodes.get(18).add(3);
        
        this.Nodes.get(19).add(25);
        this.Nodes.get(19).add(16);
        
        this.Nodes.get(20).add(18);
        this.Nodes.get(20).add(22);
        this.Nodes.get(20).add(28);
        this.Nodes.get(20).add(27);
        
        this.Nodes.get(21).add(23);
        this.Nodes.get(21).add(2);
        this.Nodes.get(21).add(28);
        this.Nodes.get(21).add(21);
        
        this.Nodes.get(22).add(14);
        this.Nodes.get(22).add(19);
        this.Nodes.get(22).add(22);
        this.Nodes.get(22).add(3);
        
        this.Nodes.get(23).add(9);
        this.Nodes.get(23).add(13);
        this.Nodes.get(23).add(15);
        
        this.Nodes.get(25).add(16);
        this.Nodes.get(25).add(17);
        
        this.Nodes.get(26).add(21);
        this.Nodes.get(26).add(28);
        this.Nodes.get(26).add(8);
        this.Nodes.get(26).add(7);
        
        this.Nodes.get(27).add(27);
        this.Nodes.get(27).add(21);
        this.Nodes.get(27).add(22);
        this.Nodes.get(27).add(2);
        this.Nodes.get(27).add(9);
        this.Nodes.get(27).add(8);
    }

    public ArrayList<List<Integer>> getNodes() {
        return this.Nodes;
    }
    
    
    public void print(){
        System.out.println("Node\tSub Nodes");
        System.out.println("\t1\t2\t3\t4\t5\t6");
        this.Nodes.forEach((node) -> {
            node.forEach((number)->{
                System.out.print(number+ "\t");
            });
            System.out.println("");
        });
    }
    
    
}
