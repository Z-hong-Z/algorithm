package Graph;

import java.util.HashSet;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        int[][] matrix = {{3, 1, 3}, {1, 1, 2}, {2, 2, 3}, {4, 3, 4}, {6, 4, 5}, {11, 5, 1}};
        Graph graph = Builder.builder(matrix);
        Stack<Node> nodes = new Stack<Node>();
        HashSet<Node> set = new HashSet<Node>();
        nodes.push(graph.nodes.get(1));
        set.add(graph.nodes.get(1));
        System.out.println(graph.nodes.get(1).val);

        while (nodes.size() != 0) {
            Node node = nodes.pop();
            for (Node next : node.nexts) {
                if (set.add(next)) {
                    nodes.push(node);
                    nodes.push(next);
                    set.add(next);
                    System.out.println(next.val);

                    break;
                }
            }


        }


    }
}
