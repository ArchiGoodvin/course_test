package ru.parsentev.task_015;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class CycleShift {
    private static final Logger log = getLogger(CycleShift.class);

    private final int[] values;

    public CycleShift(final int[] values) {
        this.values = values;
    }

    public int[] shift(int position)
    {
        if (values.length==1 || position==values.length) return values;
        while (position>values.length) position= position-values.length;

        int dop0 = values[0];
        int dop1 = 0;
        int index = 0;
        int startCycle = 0;
        for (int i = 0; i < values.length; i++) {
            if ((index+position)>=values.length) {
                index = index-values.length;}

            dop1 = values[index+position];
            values[index+position]= dop0;
            dop0 = dop1;

            if ((index+position)==startCycle) {
                index++;
                dop0 = values[index+position];
                startCycle++;
            }
            index = index+position;
        }
        System.out.println(Arrays.toString(values));
        return values;
    }
}
