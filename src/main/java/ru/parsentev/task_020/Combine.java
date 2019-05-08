package ru.parsentev.task_020;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_001.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Combine {
    private static final Logger log = getLogger(Combine.class);
    private static List<List<Integer>> list = new ArrayList<List<Integer>>();

    private final int[] values;


    public Combine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> generate() {
        List<Integer> valuesList = new ArrayList(Arrays.asList(values));

        return generate(valuesList, 0);
    }

    static List<List<Integer>> generate(List<Integer> arr, int k) {
        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            generate(arr, k + 1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            list.add(arr);
        }
        System.out.println(list);
        return list;
    }

}
/*
public class Combine{
    static void permute(java.util.List<Integer> arr, int k){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            System.out.println(java.util.Arrays.toString(arr.toArray()));
        }
    }
    public static void main(String[] args){
        Combine.permute(java.util.Arrays.asList(1,2,3,4), 0);
    }
}*/
