/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package og.jboss.arquillian.jacocointegration.test.utils;

import java.io.File;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.spec.servlet.web.WebAppDescriptor;

public class Deployments {
    public static final String COBERTURA_JAR = "net.sourceforge.cobertura:cobertura:1.9.4.1";

    public static WebArchive createCDIDeployment() {

        WebArchive war = createBaseDeployment();
        war.setWebXML(new StringAsset(createCDIWebXML().exportAsString()));
        war.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

        return war;
    }

    public static WebArchive createDeployment() {
        WebArchive war = createBaseDeployment();
        war.setWebXML(new StringAsset(createWebXML().exportAsString()));

        return war;
    }

    private static WebArchive createBaseDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class).addAsWebInfResource(
                new File("src/test/webapp/WEB-INF/faces-config.xml"), "faces-config.xml");

        return war;
    }


    public static WebAppDescriptor createCDIWebXML() {
        WebAppDescriptor desc = Descriptors.create(WebAppDescriptor.class);
        appendBaseWebXML(desc);
        return desc;
    }

    public static WebAppDescriptor createWebXML() {
        WebAppDescriptor desc = Descriptors.create(WebAppDescriptor.class);
        appendBaseWebXML(desc);
        return desc;
    }

    private static void appendBaseWebXML(WebAppDescriptor desc) {
        desc.displayName("Zion Faces TestCase")
        .welcomeFile("index.xhtml")
        .servlet("javax.faces.webapp.FacesServlet", "*.xhtml").loadOnStartup(1);
    }
}
