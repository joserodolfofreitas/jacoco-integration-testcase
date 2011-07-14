package org.jboss.arquillian.jacocointegration.dummy;

import javax.inject.Inject;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.jacocointegration.test.utils.Deployments;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class DummyClassTest {

    @Inject
    DummyClass dummyClass;

    @Deployment
    public static WebArchive createDeployment() {

        WebArchive war = Deployments.createCDIDeployment();
        war.addClass(DummyClass.class);

        return war;
    }

    @Test
    public void FailTest() {
        Assert.assertTrue(!dummyClass.fail());
    }

}
