package org.jboss.arquillian.jacocointegration.dummy;

import junit.framework.Assert;

import org.junit.Test;

public class DummyClassJUnitTest {

    DummyClass dummyClass = new DummyClass();

    @Test
    public void getFooTest() {
        Assert.assertEquals("foo", dummyClass.getFoo());
    }
}
