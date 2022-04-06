package 前缀树;

public class Builder {
    public static TrimTree root = new TrimTree();


    public static void main(String[] args) {
        insert("hello");
        insert("hella");

    }

    public static void insert(String word){
        if (word == null) return;
        char[] chs = word.toCharArray();
        TrimTree node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index  = chs[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrimTree();
            }
            TrimTree next = node.nexts[index];
            next.pass++;
            node = next;
        }
        node.end++;
    }
}
