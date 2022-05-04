package TrimTree;

public class Utils {
    private static TrimTree root = new TrimTree();


    private Utils() {

    }

    public static TrimTree getInstance() {
        return root;
    }

    public static void insertTree(String word) {
        TrimTree node = root;
        char[] chs = word.toCharArray();
        node.pass++;
        if (chs.length == 0) {
            node.end++;
            return;
        }
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrimTree();
            }
            node.next[index].pass++;
            node = node.next[index];
        }
        node.end++;
    }


    public static int search(String word) {
        TrimTree node = root;
        char[] chs = word.toCharArray();
        int index = 0;
        if (chs.length == 0) {
            return node.end;
        }
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
            if (i == chs.length - 1) {
                return node.end;
            }

        }
        return 0;
    }

    public static int getNumber(String trim) {
        TrimTree node = root;
        char[] chs = trim.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
            if (i == chs.length - 1) {
                return node.pass;
            }
        }
        return 0;
    }


    public static void delete(String word) {
        if (search(word) <= 0) return;
        TrimTree node = root;
        char[] chs = word.toCharArray();
        if (chs.length == 0) {
            node.end--;
        }
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            node.next[index].pass--;
            if (node.next[index].pass == 0){
                node.next[index] = null;
                return;
            }
            node = node.next[index];
            if (i == chs.length - 1) {
                node.end--;
            }
        }
    }
}
