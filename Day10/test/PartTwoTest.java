package test;

import org.junit.Assert;
import org.junit.Test;
import src.App;
import src.PartTwo;

public class PartTwoTest {
    @Test
    public void testPartTwo(){
        PartTwo partTwo = new PartTwo("test/test.txt");
        PartTwo partTwoB = new PartTwo("test/test2.txt");
        Assert.assertEquals(8, partTwo.solve(), 0.0);
        Assert.assertEquals(19208, partTwoB.solve(), 0.0);
    }
}
