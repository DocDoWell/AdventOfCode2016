package test;

import junit.framework.Assert;
import org.junit.Test;
import src.PartOne;

public class PartOne_Test {

    PartOne partOne = new PartOne("test/inputTest.txt");

    @Test
    public void testgetHighestSetId(){
        Assert.assertEquals(820, partOne.getHighestSetId());
    }
}
