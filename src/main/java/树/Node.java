package 树;

public class Node implements Comparable<Integer>{
    public int val;
    public Node left;
    public Node right;

    @Override
    public int compareTo(Integer o) {
        return val - o > 0 ? -1 : 1;
    }
}
