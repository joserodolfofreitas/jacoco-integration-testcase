package og.jboss.arquillian.jacocointegration.dummy;

import javax.inject.Named;

/**
 * Dummy Class to make some arquillian tests
 * 
 * @author jose.freitas
 */


@Named
public class DummyClass {
    /**
     * Default constructor
     */
    public DummyClass() {
    }

    public boolean fail() {
        boolean a = false;
        if (a) {
            a = !a;
        }

        return a;
    }

    public String getFoo() {
        return "foo";
    }
}
