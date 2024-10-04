package test;

import junit.framework.Assert;
import org.junit.Test;
import src.PartTwo;

public class PartTwo_Test {

    PartTwo partTwo = new PartTwo("test/testInput.txt");

    @Test
    public void testGetNumberOfTrees(){
        double actualAnswer= partTwo.getNumberOfTrees();
        int expectedAnswer = 336;
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }
}
