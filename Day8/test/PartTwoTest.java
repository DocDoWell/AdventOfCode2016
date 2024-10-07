package test;

import junit.framework.Assert;
import org.junit.Test;
import src.PartTwo;

public class PartTwoTest {
    @Test
    public void testPartOne(){
        PartTwo partTwo = new PartTwo("test/test.txt");
        partTwo.solve();
        Assert.assertEquals(8, partTwo.accumulator);
    }
}
