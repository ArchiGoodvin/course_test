package ru.parsentev.task_009;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class UniqueChars {
    private final String line;

    public UniqueChars(final String line) {
        this.line = line;
    }

    public int unique() {
        if (line==null || line.equals("")) return 0;
        String symbol = line.substring(0,1);
        int result = 1;

        int length = line.length();
        String lineX = line;
        int counter = 1;
        while (counter<length) {
            if (!lineX.substring(counter, counter + 1).equals(symbol)) {
                lineX = lineX.replaceAll(lineX.substring(counter, counter + 1), symbol);
                result++;
            }
            counter++;
        }
        return result;
    }

}
