package 图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Graph {

    HashMap<Integer,Node> nodes;
    HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
