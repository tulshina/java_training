package ru.stqa;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by User on 19.02.2017.
 */
public class SquareTests {

    @Test
    public void testArea() {
        Square s = new Square(5.0);
        Assert.assertEquals(s.area(), 25.0);
    }
}
