package 小和问题;

import java.util.Arrays;

public class Main {
    public static int ret = 0;
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 2, 1, 5};
        merge(array,0,array.length - 1);
        Arrays.stream(array).forEach(System.out::println);
        System.out.println(ret);
    }
    //小和问题


    public static void merge(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        merge(array, L, mid);
        merge(array, mid + 1, R);
        sort(array, L, mid, R);
    }

    public static void sort(int[] array, int l, int mid, int r) {
        int[] tmpList = new int[r - l + 1];
        int index = 0;
        int i = l;
        int j = mid + 1;
        while (i <= mid && j <= r) {
            if (array[i] < array[j]) {
                ret = ret + array[i] * (r - j + 1);
                tmpList[index++] = array[i++];
            } else {
                tmpList[index++] = array[j++];
            }
        }
        while (i <= mid) {
            tmpList[index++] = array[i++];
        }

        while (j <= r) {
            tmpList[index++] = array[j++];
        }

        for (int in = l; in <= r; in++) {
            array[in] = tmpList[in - l];
        }
    }
}
