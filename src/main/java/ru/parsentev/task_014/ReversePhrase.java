package ru.parsentev.task_014;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class ReversePhrase {
    private static final Logger log = getLogger(ReversePhrase.class);
    private final String line;

    public ReversePhrase(final String line) {
        this.line = line;
    }

    public String reverse() {
        ArrayList<String> arrayList = new ArrayList<String>();
        int i=0;
        int index = 0;
        int indexArray = 0;

        while (i<=line.length()){
            if ((i == line.length()) || line.substring(i, i+1).equals(" ")){
                arrayList.add(line.substring(index, i));
                index = i+1;
                indexArray++;
            }
            i++;
        }
        String result=arrayList.get(indexArray-1);
        for (int j = indexArray-1; j > 0 ; j--) {
            result = result +" " + arrayList.get(j-1);
        }
        return result;

    }
}
