package 图;

import java.util.HashSet;
import java.util.LinkedList;

public class BFS {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,2},
                {2,1,4},
                {11,2,3},
                {2,3,4},
                {4,4,5},
                {11,5,2}
        };
        Graph graph = Builder.builder(matrix);
        BFS(graph);
    }


    public static void BFS(Graph graph){
        LinkedList<Node> queue = new LinkedList<>();
        HashSet<Node> nodes = new HashSet<>();
        nodes.add(graph.nodes.get(1));
        queue.add(graph.nodes.get(1));
        while (!queue.isEmpty()) {
            Node firstNode = queue.removeFirst();
            System.out.println(firstNode.val);
            for (Node next : firstNode.nexts) {
                if (nodes.add(next)) {
                    queue.add(next);
                }
            }
        }
    }
}
