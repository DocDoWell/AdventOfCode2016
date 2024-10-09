package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.PartOne;


public class PartOneTest {
    @Test
    public void testPartOne(){
        PartOne partOne = new PartOne("test/test.txt");
        Assertions.assertEquals(37,partOne.solve());
    }
}
