package 快速排序;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    public static int getIndex(int[] arr, int low, int high) {
        int index = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= index) {
                high--;
            }
            if (low < high) {
                arr[low] = arr[high];
            }
            while (low < high && arr[low] <= index) {
                low++;
            }
            if (low < high) {
                arr[high] = arr[low];
            }
        }
        arr[low] = index;
        return low;
    }
}
