package 堆排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSort {
    static class Csort implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {

        switch (args[0]) {
            case " ":
                System.out.println();
                break;
            case "1":
            default:
                break;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Csort());
        heap.add(1);
        heap.add(-1);
        while (heap.size() != 0) {
            System.out.println(heap.poll());
        }


    }

    public static int[] insert(int[] heap, int val) {
        if (heap == null) {
            return new int[]{val};
        }
        int[] newHeap = new int[heap.length + 1];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        int index = newHeap.length - 1;
        newHeap[index] = val;
        heapInsert(newHeap, index);
        return newHeap;
    }

    public static void heapfiy(int[] heap, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = index + 1 < heapSize && heap[index] < heap[index + 1] ? left + 1 : left;
            largest = heap[largest] > heap[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(heap, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void heapInsert(int[] heap, int index) {
        // @ parm1 堆数组
        // @ parm2 插入的位置
        while (heap[index] > heap[(index - 1) / 2]) {
            swap(heap, index, ((index - 1) / 2));
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] heap, int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
