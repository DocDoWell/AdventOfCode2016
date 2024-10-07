package test;

import junit.framework.Assert;
import org.junit.Test;
import src.PartOne;

public class PartOneTest {

    @Test
    public void testPartOne(){
        PartOne partOne = new PartOne("test/test.txt");
        partOne.solve();
        Assert.assertEquals(5, partOne.accumulator);
    }
}
