package test;

import junit.framework.Assert;
import org.junit.Test;
import src.PartOne;


public class PartOneTest {

    PartOne partOne = new PartOne("test/inputTest.txt");

    @Test
    public void getAnswersTest(){
        Assert.assertEquals(11, partOne.getAnswers());
    }
}
