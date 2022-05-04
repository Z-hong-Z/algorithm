package 约瑟夫环;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(loop(5, 1));
    }


    public static int loop(int size, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            queue.add(i);
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < k; j++) {
                queue.add(queue.removeFirst());
            }
            queue.removeFirst();
        }
        return queue.removeFirst();
    }
}
