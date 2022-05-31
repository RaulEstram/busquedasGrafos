package data;

import java.util.*;

public class Node {
    
    private final String name;
    private final List<Node> subNodes;
    private final int distance;
    
    public Node(final String name){
        this.name = name;
        this.subNodes = new ArrayList<>();
        this.distance = 0;
    }
    
    public Node(final String name, final List<Node> subNodes){
        this.name = name;
        this.subNodes = subNodes;
        this.distance = 0;
    }
    
    public Node(final String name, final int distance, final List<Node> subNodes){
        this.name = name;
        this.subNodes = subNodes;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public List<Node> getSubNodes() {
        return subNodes;
    }

    public int getDistance() {
        return distance;
    }
    
    
    
}
