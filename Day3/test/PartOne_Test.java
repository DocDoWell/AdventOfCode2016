package test;

import junit.framework.Assert;
import org.junit.Test;
import src.PartOne;

public class PartOne_Test {

    PartOne partOne = new PartOne("test/testInput.txt");

    @Test
    public void testGetNumberOfTrees(){
        int actualAnswer= partOne.getNumberOfTrees();
        int expectedAnswer = 7;
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }
}
