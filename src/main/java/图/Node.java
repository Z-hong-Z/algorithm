package 图;


import java.util.ArrayList;

public class Node {
    public int val;

    public int in;
    public int out;

    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int val) {
        this.val = val;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", in=" + in +
                ", out=" + out +
                '}';
    }
}
