package Graph;


import java.util.*;

public class ToplogySort {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 2},
                {2, 1, 4},
                {11, 2, 3},
                {2, 3, 4},
                {4, 4, 5},
                {11, 5, 2}
        };
        Graph graph = Builder.builder(matrix);
        List<Node> nodes = toplogySort(graph);
        for (Node node : nodes) {
            System.out.println(node.val);
        }
    }

    public static List<Node> toplogySort(Graph graph) {
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, Integer> nodeMap = new HashMap<>();
        // Key 节点编号
        // Value 剩余入度
        for (Integer integer : graph.nodes.keySet()) {
            nodeMap.put(integer, graph.nodes.get(integer).in);
            if (graph.nodes.get(integer).in == 0) {
                queue.add(graph.nodes.get(integer));
            }
        }

        //sort
        ArrayList<Node> ret = new ArrayList<Node>();
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            ret.add(poll);
            for (Node next : poll.nexts) {
                int val = next.val;
                nodeMap.put(val,nodeMap.get(val) - 1);
                if (nodeMap.get(val) == 0) {
                    queue.add(graph.nodes.get(val));
                }
            }
        }
        return  ret;


    }
}
