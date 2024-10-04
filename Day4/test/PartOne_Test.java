package test;

import junit.framework.Assert;
import org.junit.Test;
import src.PartOne;

public class PartOne_Test {
    PartOne partOne = new PartOne("test/testInput.txt");

    @Test
    public void testGetValidPassports(){
        int actualAnswer= partOne.getValidPassports();
        int expectedAnswer = 2;
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }
}
