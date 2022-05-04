package 前缀树;

import java.util.Scanner;

public class Builder {
    public static TrimTree root = new TrimTree();
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        insert("hella");
        insert("hellb");
        insert("hellc");
        insert("helld");
        insert("helle");
        insert("hellf");
        insert("hello");
        insert("hello");
        insert("hello");
        insert("hello");
        deleteWord("hello");
        System.out.println(search("hello"));
    }

    public static int getNumber(String trim){
        char[] chs = trim.toCharArray();
        int index = 0;
        TrimTree node = root;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }

            node = node.nexts[index];
            if (i == chs.length - 1){
                return node.pass;
            }
        }
        return 0;

    }



    public static void insert(String word){
        if (word == null) return;
        char[] chs = word.toCharArray();
        TrimTree node = root;
        node.pass ++ ;
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

    public static int search(String word){
        char[] chs = word.toCharArray();
        int index = 0;
        TrimTree node = root;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null){
                return 0;
            }

            node = node.nexts[index];
            if (i == chs.length - 1){
                return node.end;
            }
        }
        return 0;
    }


    public static void deleteWord(String word){
        int result = search(word);
        if (result == 0){
            return;
        }

        char[] chs = word.toCharArray();
        int index = 0;
        TrimTree node = root;
        node.pass--;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (--node.nexts[index].pass == 0){
                node.nexts[index] = null;
                return;
            }
            node = node.nexts[index];
            node.pass--;
            if (i == chs.length - 1){
                node.end--;
            }
        }


    }
}
