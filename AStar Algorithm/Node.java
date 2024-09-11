package collection;
import java.util.*;

public class Node {
	public final String name;
    public final Map<Node, Integer> neighbors = new HashMap<>();
    public int gScore = Integer.MAX_VALUE;  // Cost from start node
    public int hScore = Integer.MAX_VALUE;  // Heuristic score
    public Node previous = null;

    public Node(String name) {
        this.name = name;
    }
    
    public void addNeighbor(Node neighbor, int cost) {
        neighbors.put(neighbor, cost);
    }

    public String toString() {
        return name;
    }


}
