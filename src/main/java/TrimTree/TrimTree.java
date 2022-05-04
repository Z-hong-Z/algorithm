package TrimTree;

public class TrimTree {
    public int pass;
    public int end;
    public TrimTree[] next;

    public TrimTree() {
        next = new TrimTree[26];
    }
}
