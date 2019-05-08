package ru.parsentev.task_018;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Pool {
    private static final Logger log = getLogger(Pool.class);

    private final int[][] values;

    public Pool(final int[][] values) {
        this.values = values;
    }

    public int maxUnion()
    {
        int count = 0;
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j <values[0].length ; j++) {
                if (values[i][j] == 1)
                {count = maxUnion (i,j);
                 if (max<count) max=count;}
            }
        }
        return max;
    }

    private int maxUnion (int x, int y){

        if (x > values.length-1
            || y > values[0].length-1
                || values[x][y] == 0) return 0;

        values[x][y] = 0;
        return 1 + maxUnion(x+1,y)
                + maxUnion(x,y+1);
    }
}
