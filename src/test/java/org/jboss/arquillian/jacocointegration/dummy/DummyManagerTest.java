package org.jboss.arquillian.jacocointegration.dummy;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.jacocointegration.dummy.DummyManager;
import org.jboss.arquillian.jacocointegration.dummy.StatelessDummyManager;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class DummyManagerTest {

    @Deployment
    public static WebArchive createDeployment() 
    {
        return ShrinkWrap.create(WebArchive.class)
              .addClasses(DummyManager.class, StatelessDummyManager.class)
              .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    private DummyManager manager;
    
    @Test
    public void shouldBeAbleToDoComplicatedStuff() 
    {
       manager.doComplicatedStuff();
    }
}
