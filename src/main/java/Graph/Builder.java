package Graph;

public class Builder {
    public static void main(String[] args) {
        int[][] graph = {
                {3, 1, 3},
                {1, 1, 2},
                {2, 2, 3}
        };
        Graph graph1 = builder(graph);

    }

    static Graph builder(int[][] matrix) {
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
            Edges edges = new Edges(from, to, val);
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            fromNode.nexts.add(toNode);
            fromNode.edges.add(edges);
            toNode.edges.add(edges);
            graph.edges.add(edges);
            fromNode.out++;
            toNode.in++;
        }
        return graph;
    }
}
