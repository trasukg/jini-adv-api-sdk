/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.river.container.advapi;

import java.util.logging.Logger;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

/**
 *
 * @author trasukg
 */
public class AdvAPIExtension implements Extension {

    private static Logger log=Logger.getLogger(AdvAPIExtension.class.getName());
    
    void beforeBeanDiscovery(@Observes BeforeBeanDiscovery bbd) {

        log.info("beginning the scanning process");

    }

    <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> pat) {

        log.info("scanning type: " + pat.getAnnotatedType().getJavaClass().getName());

    }

    void afterBeanDiscovery(@Observes AfterBeanDiscovery abd) {
 
        log.info("finished the scanning process");

    }

}
