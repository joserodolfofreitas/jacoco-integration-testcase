package og.jboss.arquillian.jacocointegration.dummy;

import javax.inject.Inject;

import junit.framework.Assert;
import og.jboss.arquillian.jacocointegration.test.utils.Deployments;

import org.jboss.arquillian.container.test.api.Deployment;
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

    @Test
    public void getFooTest() {
        Assert.assertEquals("foo", dummyClass.getFoo());
    }
}
