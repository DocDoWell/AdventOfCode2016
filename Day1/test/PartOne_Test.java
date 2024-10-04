package test;

import junit.framework.Assert;
import org.junit.Test;
import src.PartOne;

public class PartOne_Test {

    PartOne partOne = new PartOne("test/testInput.txt");

    @Test
    public void testMultiplyEntries(){
        int actualAnswer= partOne.multiplyEntries();
        int expectedAnswer = 514579;
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

}
