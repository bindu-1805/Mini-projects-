package collection;
import java.util.*;

public class AStar {
    public static List<Node> findPath(Node start, Node goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(n -> n.gScore + n.hScore));
        Set<Node> closedSet = new HashSet<>();

        start.gScore = 0;
        start.hScore = heuristic(start, goal);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.equals(goal)) {
                return reconstructPath(goal);
            }

            closedSet.add(current);

            for (Map.Entry<Node, Integer> neighborEntry : current.neighbors.entrySet()) {
                Node neighbor = neighborEntry.getKey();
                int cost = neighborEntry.getValue();

                if (closedSet.contains(neighbor)) {
                    continue;
                }

                int tentativeGScore = current.gScore + cost;

                if (!openSet.contains(neighbor)) {
                    openSet.add(neighbor);
                } else if (tentativeGScore >= neighbor.gScore) {
                    continue;
                }

                neighbor.previous = current;
                neighbor.gScore = tentativeGScore;
                neighbor.hScore = heuristic(neighbor, goal);
            }
        }

        return Collections.emptyList();  // Path not found
    }

    private static int heuristic(Node a, Node b) {
        // Simple heuristic function, you may use more complex heuristics
        return Math.abs(a.name.hashCode() - b.name.hashCode());
    }

    private static List<Node> reconstructPath(Node goal) {
        List<Node> path = new ArrayList<>();
        Node current = goal;

        while (current != null) {
            path.add(current);
            current = current.previous;
        }

        Collections.reverse(path);
        return path;
    }

}
