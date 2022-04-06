package 桶排序;

import java.util.Arrays;
import java.util.LinkedList;

public class bucketSort {
    public static void main(String[] args) {
        int[] array = {111,222,333,90,100,111};
        bucketsort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void bucketsort(int[] array) {
        int len = getLen(array);
        LinkedList<Integer>[] bucket = new LinkedList[10];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedList<>();
        }

        for (int i = 0; i < len; i++) {
            for (int k : array) {
                int bit = getBit(k, i);
                bucket[bit].addLast(k);
            }
            int index = 0;
            for (LinkedList<Integer> integers : bucket) {
                while (integers.size()!=0){
                    array[index++] = integers.removeFirst();
                }
            }
        }
        int index = 0;
        for (LinkedList<Integer> integers : bucket) {
            while (integers.size() != 0) {
                Integer integer = integers.removeFirst();
                array[index++] = integer;
            }
        }
    }

    public static int getBit(int val, int b) {
        for (int i = 0; i < b; i++) {
            val = val / 10;
        }
        return val % 10;
    }

    public static int getLen(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (i > max) max = i;
        }
        int ret = 0;
        while (max > 0) {
            max = max / 10;
            ret++;
        }
        return ret;
    }
}
