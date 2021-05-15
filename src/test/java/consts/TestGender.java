package consts;

import org.junit.Assert;
import org.junit.Test;

public class TestGender {

    @Test
    public void testFromString() {
        Gender actualMale = Gender.fromString("male");
        Gender expectedMale  =  Gender.MALE;

        Assert.assertTrue(actualMale == expectedMale);

        Gender actualFemale = Gender.fromString("female");
        Gender expectedFemale  =  Gender.FEMALE;
        Assert.assertTrue(actualFemale == expectedFemale);
    }


    @Test
    public void testFromString_withCaps() {
        Gender actualMale = Gender.fromString("Male");
        Gender expectedMale  =  Gender.MALE;

        Assert.assertTrue(actualMale == expectedMale);

        Gender actualFemale = Gender.fromString("Female");
        Gender expectedFemale  =  Gender.FEMALE;
        Assert.assertTrue(actualFemale == expectedFemale);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromString_withInvalidString() {
        Gender.fromString("abc");
    }
}
