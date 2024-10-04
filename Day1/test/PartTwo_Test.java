package test;

import junit.framework.Assert;
import org.junit.Test;
import src.PartTwo;

public class PartTwo_Test {

    PartTwo partTwo = new PartTwo("test/testInput.txt");

    @Test
    public void testMultiplyEntries(){
        int actualAnswer= partTwo.multiplyEntries();
        int expectedAnswer = 241861950;
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }
}
