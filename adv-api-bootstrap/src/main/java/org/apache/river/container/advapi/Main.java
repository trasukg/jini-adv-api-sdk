package org.apache.river.container.advapi;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

/**
 * Hello world!
 *
 */
@Named("org.apache.river.container.advapi.main")
public class Main {

    private static ContainerLifecycle lifecycle = null;

    private static void boot(Object startupObject) throws Exception {
        try {
            lifecycle = WebBeansContext.getInstance().getService(ContainerLifecycle.class);
            lifecycle.startApplication(startupObject);

        } catch (Exception e) {
            throw e;
        }
    }

    private static void shutdown(Object endObject) throws Exception {
        try {
            lifecycle.stopApplication(endObject);

        } catch (Exception e) {
            throw e;
        }

    }

    public static void main(String[] args) {
        try {
            // Initialize the CDI subsystem.
            boot(null);

            // Request an instance of Main
            //  - this will cause CDI to collect all the other services, etc, and
            BeanManager beanManager = lifecycle.getBeanManager();
            Bean<?> bean = beanManager.getBeans("org.apache.river.container.advapi.main").iterator().next();
            
            Main mainObject = (Main) lifecycle.getBeanManager().getReference(bean, Main.class, beanManager.createCreationalContext(bean));
            mainObject.run(args);
            // Get a list of @Services
            // Export them
            // Make the proxies available to beans.
            // Start the default join to register all services.
            // Fire the @AfterJoin event.
            
            System.out.println("We retrieved the main class");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Inject
    AdvAPIExtension advAPIExtension;
    
    public void run(String[] args) {
        System.out.println("Here's me running the app.");
        System.out.println("And the extension is:" + advAPIExtension);
    }
}
