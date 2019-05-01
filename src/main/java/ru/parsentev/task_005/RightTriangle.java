package ru.parsentev.task_005;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_002.Point;
import ru.parsentev.task_003.Triangle;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class RightTriangle extends Triangle {
    private static final Logger log = getLogger(RightTriangle.class);

    public RightTriangle(Point first, Point second, Point third) {
        super(first, second, third);
    }

    @Override
    public boolean exists() {
        boolean result = false;
        if ((getAb()>getAc() && (getAb()>getBc()))) {
            if (Math.round(getAb() * getAb()) == getBc() * getBc() + getAc() * getAc()) {
                result = true;
            }
        }
        if ((getBc()>getAc()) && (getBc()>getAb())) {
            if (Math.round(getBc() * getBc()) == getAb() * getAb()+ getAc() * getAc()) {
                result = true;
            }
        }
        if ((getAc()>getBc()) && (getAc()>getAb())) {
            if (Math.round(getAc() * getAc()) == getAb() * getAb()+ getBc() * getBc()) {
                result = true;
            }
        }
        return (super.exists() && result);
    }
}
