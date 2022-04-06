package 前缀树;

import java.util.ArrayList;

public class TrimTree {
    public int end;
    public int pass;
    public TrimTree[] nexts;

    public TrimTree() {
        nexts = new TrimTree[26];
    }
}
