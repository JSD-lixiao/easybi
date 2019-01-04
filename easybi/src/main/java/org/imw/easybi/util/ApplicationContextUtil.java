package org.imw.easybi.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    private  static ApplicationContext applicationContext;

    public ApplicationContextUtil() {
    }
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
