package org.jboss.arquillian.jacocointegration.dummy;

import junit.framework.Assert;

import org.jboss.arquillian.jacocointegration.dummy.DummyClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class DummyClassJUnitTest {

    DummyClass dummyClass = new DummyClass();

    @Test
    public void getFooTest() {
        Assert.assertEquals("foo", dummyClass.getFoo());
    }
}