package collection;
import java.util.*;
public class AStarDemo {

	public static void main(String[] args) {
		
		Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");

        a.addNeighbor(b, 1);
        a.addNeighbor(c, 4);
        b.addNeighbor(c, 2);
        b.addNeighbor(d, 5);
        c.addNeighbor(d, 1);
        c.addNeighbor(e, 3);
        d.addNeighbor(e, 1);
        e.addNeighbor(f, 1);

        List<Node> path = AStar.findPath(a, f);
        System.out.println("Path from A to F:");
        for (Node node : path) {
            System.out.print(node + " ");
        }

	}

}
