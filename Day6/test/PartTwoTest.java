package test;

import junit.framework.Assert;
import org.junit.Test;
import src.PartOne;
import src.PartTwo;

public class PartTwoTest {

    PartTwo partTwo = new PartTwo("test/inputTest.txt");

    @Test
    public void getAnswersTest(){
        Assert.assertEquals(6, partTwo.getAnswers());
    }
}
