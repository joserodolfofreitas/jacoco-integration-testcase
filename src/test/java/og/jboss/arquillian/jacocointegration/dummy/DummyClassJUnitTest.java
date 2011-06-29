package og.jboss.arquillian.jacocointegration.dummy;

import junit.framework.Assert;

import og.jboss.arquillian.jacocointegration.dummy.DummyClass;

import org.junit.Test;


public class DummyClassJUnitTest {

    DummyClass dummyClass = new DummyClass();

    @Test
    public void getFooTest() {
        Assert.assertEquals("foo", dummyClass.getFoo());
    }
}
