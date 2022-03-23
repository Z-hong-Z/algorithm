package 冒泡排序;

import java.util.Arrays;

public class BluleSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
