package 选择排序;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        insertSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }


    public static void insertSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i +  1; j < array.length; j++) {
                if (array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            if (i != minIndex){
                swap(array,i,minIndex);
            }
        }
    }

    public static void swap(int[] array,int i ,int j){
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
