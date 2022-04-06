package Graph;

import java.util.HashSet;
import java.util.LinkedList;

public class BFS {
    public static void main(String[] args) {
        int[][] graph = {
                {3, 1, 3},
                {1, 1, 2},
                {2, 2, 3},
                {4, 3, 4},
                {6, 4, 5},
                {11, 5, 1}
        };
        Graph graph1 = Builder.builder(graph);
        HashSet<Node> set = new HashSet<Node>();
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(graph1.nodes.get(1));
        set.add(graph1.nodes.get(1));
        while (queue.size() != 0) {
            Node node = queue.removeFirst();
            System.out.println(node.val);
            for (Node next : node.nexts) {
                if (set.add(next)) {
                    queue.add(next);
                }
            }
        }
    }
}
