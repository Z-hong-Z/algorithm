package 图;

public class Builder {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,2},
                {2,1,3},
                {11,2,3}
        };
        Graph graph = builder(matrix);
        for (Integer integer : graph.nodes.keySet()) {
            System.out.println(graph.nodes.get(integer));
        }
    }

    public static Graph builder(int[][] matrix){
        Graph graph = new Graph();
        for (int[] ints : matrix) {
            int val = ints[0];
            int from = ints[1];
            int to = ints[2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(from, to, val);

            fromNode.out++;
            toNode.in++;
            graph.edges.add(edge);
            fromNode.nexts.add(toNode);
            fromNode.edges.add(edge);
            toNode.edges.add(edge);

        }
        return graph;
    }
}
