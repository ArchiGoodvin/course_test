package ru.parsentev.task_003;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_002.Point;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Triangle {
    private static final Logger log = getLogger(Triangle.class);

    protected final Point first;
    protected final Point second;
    protected final Point third;
    double ab;
    double bc;
    double ac;


    public Triangle(final Point first, final Point second, final Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
        ab = first.distanceTo(second);
        bc = second.distanceTo(third);
        ac = first.distanceTo(third);
    }

    public boolean exists()
    {
        if ((ab+bc>ac) && (ab+ac>bc) && (ac+bc>ab)) return true;
        else return false;
    }

    public double area() {
        if (exists()) {
            double p = (ab + bc + ac) / 2.0;
            return Math.round(Math.sqrt(p * (p - ab) * (p - bc) * (p - ac)));
        } else {
            throw new IllegalStateException();
        }
    }

        public double getAb() {
        return ab;
    }

        public double getBc() {
        return bc;
    }

        public double getAc() {
        return ac;
    }

}
