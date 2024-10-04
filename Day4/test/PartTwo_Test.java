package test;

import junit.framework.Assert;
import org.junit.Test;
import src.PartTwo;

public class PartTwo_Test {

    PartTwo partTwoInvalids = new PartTwo("test/invalidTest.txt");
    PartTwo partTwoValids = new PartTwo("test/validTest.txt");

    @Test
    public void testGetValidPassports(){
        int actualAnswer= partTwoInvalids.getValidPassports();
        int expectedAnswer = 0;
        Assert.assertEquals(expectedAnswer, actualAnswer);

        int actualValidAnswer= partTwoValids.getValidPassports();
        int expectedValidAnswer = 4;
        Assert.assertEquals(expectedValidAnswer, actualValidAnswer);
    }
}
