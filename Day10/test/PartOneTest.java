package test;

import org.junit.Assert;
import org.junit.Test;
import src.PartOne;

public class PartOneTest {
    @Test
    public void testPartOne(){
        PartOne partOne = new PartOne("test/test.txt");
        PartOne partOneB = new PartOne("test/test2.txt");
        Assert.assertEquals(35, partOne.solve());
        Assert.assertEquals(220, partOneB.solve());
    }
}
