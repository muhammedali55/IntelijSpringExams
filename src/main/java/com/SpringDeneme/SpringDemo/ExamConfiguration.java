package com.SpringDeneme.SpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ExamConfiguration {
    @Autowired
    private MuhammetProperties muhammetProperties;

    @PostConstruct
    public void init(){
        System.out.println("Görünüm Aktivitesi....: "+ muhammetProperties.isDisplayObjects());
    }
}
