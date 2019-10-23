package com.SpringDeneme.SpringDemo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "propmuhammet")
public class MuhammetProperties {
    private boolean displayObjects = false;

    public boolean isDisplayObjects() {
        return displayObjects;
    }

    public void setDisplayObjects(boolean displayObjects) {
        this.displayObjects = displayObjects;
    }
}
