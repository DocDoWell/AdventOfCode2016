package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;;
import src.PartTwo;

public class PartTwoTest {
    @Test
    public void testPartOne(){
        PartTwo partTwo= new PartTwo("test/test.txt");
        partTwo.solve();
        Assertions.assertEquals(26,partTwo.solve());
    }
}
