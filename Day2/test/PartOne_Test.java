package test;

import junit.framework.Assert;
import org.junit.Test;
import src.PartOne;
import src.PartTwo;

public class PartOne_Test {

        PartOne partOne = new PartOne("test/testInput.txt");
        PartTwo partTwo = new PartTwo("test/testInput.txt");

        @Test
        public void testValidatePasswords(){
            int actualAnswer= partOne.getValidPasswords();
            int expectedAnswer = 2;
            Assert.assertEquals(expectedAnswer, actualAnswer);
        }

  
}
