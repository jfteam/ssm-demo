package org.jfteam.framework.holder;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/19 15:07
 */
public class PropertyHolderConfigurer extends PropertyPlaceholderConfigurer {

    private Properties properties;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        this.properties = props;
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return this.properties.getProperty(key, defaultValue);
    }

    public Object setProperty(String key, String value) {
        return this.properties.setProperty(key, value);
    }
}
