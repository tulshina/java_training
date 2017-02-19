package ru.stqa;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by User on 19.02.2017.
 */
public class PointTests {
    @Test
    public void testDistance() {
        Point p1 = new Point(3.5, 1);
        Point p2 = new Point(1, 1);

        double expectedDistance = 2.5;
        double actualDistance = p1.distance(p2);

        Assert.assertEquals(actualDistance, expectedDistance);
    }

    @Test
    public void testDistanceZero() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,0);

        double expectedDistance = 0;
        double actualDistance = p1.distance(p2);

        Assert.assertEquals(actualDistance, expectedDistance);
    }
}
