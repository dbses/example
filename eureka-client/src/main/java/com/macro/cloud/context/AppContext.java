package com.macro.cloud.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

@Component
public final class AppContext implements ApplicationContextAware, InitializingBean {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public void setProperty(String key, String value) {
        context.getEnvironment();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.setProperty("eureka.instance.metadata-map.courier", "99");
        StandardEnvironment environment = (StandardEnvironment) context.getEnvironment();
        environment.getPropertySources();
    }
}
