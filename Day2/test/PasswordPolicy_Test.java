package test;

import org.junit.Assert;
import org.junit.Test;
import src.PasswordPolicy;

public class PasswordPolicy_Test {

    PasswordPolicy passwordPolicyA = new PasswordPolicy(1,3,'a', "abcde");
    PasswordPolicy passwordPolicyB = new PasswordPolicy(1,3,'b', "cdefg");
    PasswordPolicy passwordPolicyC = new PasswordPolicy(2,9,'c', "ccccccccc");

    @Test
    public void testIsPasswordValid(){
        Assert.assertTrue(passwordPolicyA.isPasswordValid());
        Assert.assertTrue(!passwordPolicyB.isPasswordValid());
    }

    @Test
    public void testIsPasswordValidForPartTwo(){
        Assert.assertTrue(passwordPolicyA.isPasswordValidForPartTwo());
        Assert.assertTrue(!passwordPolicyC.isPasswordValidForPartTwo());
    }
}
