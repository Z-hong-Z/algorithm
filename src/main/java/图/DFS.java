package 图;

import java.util.HashSet;
import java.util.Stack;

public class DFS {
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
        DFS(graph);
    }
    public static void DFS(Graph graph){
        HashSet<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        set.add(graph.nodes.get(1));
        stack.push(graph.nodes.get(1));
        System.out.println(graph.nodes.get(1));
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            for (Node next : node.nexts) {
                if (set.add(next)) {
                    System.out.println(next);
                    stack.push(node);
                    stack.push(next);
                    break;
                }
            }

        }




    }
}
