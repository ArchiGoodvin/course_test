package ru.parsentev.task_007;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_001.Calculator;

import java.util.ArrayList;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Expression {
    private static final Logger log = getLogger(Expression.class);

    private final String expr;

    public Expression(final String expr) {
        this.expr = expr;
    }

    public double calc() {
        try {

            char[] chars = expr.toCharArray();
            boolean[] booleans = new boolean[chars.length];
            double result = 0;
            int index1 = 0;
            int index2 = 0;
            ArrayList<Float> numbers = new ArrayList<Float>();
            String stringNumber = "";

            for (int i = 0; i < chars.length; i++) {
                switch (chars[i]) {
                    case '+':
                    case '-':
                    case '*':
                    case '/': {
                        booleans[i] = true;
                        index2 = i;
                        stringNumber = expr.substring(index1, index2);
                        numbers.add(Float.parseFloat(stringNumber));
                        index1 = index2 + 1;
                    }
                }
            }
            stringNumber = expr.substring(index1, chars.length);
            numbers.add(Float.parseFloat(stringNumber));

            Calculator calculator = new Calculator();
            int j = 0;
            result = numbers.get(0);

            for (int i = 0; i < chars.length; i++) {
                switch (chars[i]) {
                    case '+': {
                        calculator.add(result, numbers.get(j + 1));
                        j++;
                        result = calculator.getResult();
                        break;
                    }
                    case '-': {
                        calculator.substract(result, numbers.get(j + 1));
                        j++;
                        result = calculator.getResult();
                        break;
                    }
                    case '*': {
                        calculator.multiple(result, numbers.get(j + 1));
                        j++;
                        result = calculator.getResult();
                        break;
                    }
                    case '/': {
                        calculator.div(result, numbers.get(j + 1));
                        j++;
                        result = calculator.getResult();
                        break;
                    }
                }
            }
            return result;
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }
}
