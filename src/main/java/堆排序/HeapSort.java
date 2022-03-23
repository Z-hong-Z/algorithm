package 堆排序;

public class HeapSort {
    public static void main(String[] args) {
        int[] heap = null;

        insert(insert(heap,0),1);
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
