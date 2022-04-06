package 基数排序;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //学生年龄排序
        int[] arr = {15, 15, 14, 15, 6, 10};
        sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }


    public static void sort(int[] array) {
        int[] ints = new int[15 - 6 + 1];
        for (int i : array) {
            ints[i - 6]++;
        }
        int index = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i]; j++) {
                array[index++] = i + 6;
            }
        }

    }
}
