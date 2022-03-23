package 插入排序;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        insertSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                swap(array,j,j+1);
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
