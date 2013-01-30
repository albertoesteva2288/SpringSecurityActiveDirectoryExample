/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example;

import java.io.Serializable;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtils implements ApplicationContextAware, Serializable {

    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext appContext)
            throws BeansException {
        ctx = appContext;

    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }
}
