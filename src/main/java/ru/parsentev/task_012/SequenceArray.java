package ru.parsentev.task_012;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class SequenceArray {
    private static final Logger log = getLogger(SequenceArray.class);

    private final int[] values;

    public SequenceArray(final int[] values) {
        this.values = values;
    }

    public boolean containsOneSequence()
    {
        int counter=0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 1){
                counter++;
                if (counter>2) return true;
            } else counter=0;

        }
        return false;
    }
}
