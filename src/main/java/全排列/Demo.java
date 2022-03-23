package 全排列;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {



        int[] array = {1, 2, 3};
        dfs(array,0);
        System.out.println(ret);
    }

    static List<Integer> sequence = new ArrayList<>();
    static List<List<Integer>> ret = new ArrayList<>();

    public static void dfs(int[] array, int index) {
        if (index > array.length) {
            return;
        }

        for (int i = index; i < array.length; i++) {
            sequence.add(array[i]);
            ret.add(new ArrayList<>(sequence));
            dfs(array, i + 1);
            sequence.remove(sequence.size() - 1);
        }

    }
}
