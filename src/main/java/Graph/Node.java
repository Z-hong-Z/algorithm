package Graph;

import java.util.ArrayList;

public class Node {
    public int val;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edges> edges;

    public Node(int val) {
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
        this.val = val;

    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", in=" + in +
                ", out=" + out +
                ", nexts=" + nexts +
                ", edges=" + edges +
                '}';
    }
}
