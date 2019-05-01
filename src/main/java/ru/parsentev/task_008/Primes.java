package ru.parsentev.task_008;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Primes {
    private static final Logger log = getLogger(Primes.class);

    private final int limit;

    public Primes(final int limit) {
        this.limit = limit;
    }

    public List<Integer> calc() {

        List<Integer> simple = new ArrayList<Integer>();
        simple.add(2);
        int i=3;

        while (i<=limit) {
            if (checkSimple(i, simple)) {
                simple.add(i);
            }
            i = i + 2;
        }
        return simple;
    }

    public static boolean checkSimple(int i, List<Integer> list){

        for (int j=0; j<list.size();j++){
            if (i%list.get(j) == 0) {
                return false;
            }
        }
        return true;
    }

}
