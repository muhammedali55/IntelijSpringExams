package com.SpringDeneme.SpringDemo.controller;

import com.SpringDeneme.SpringDemo.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetClinicController {

    @Autowired
    private PetClinicService petClinicService;

    @RequestMapping("/selam")
    @ResponseBody
    public String welcome(){
        return "İlk Spring Uygulamama Hoş Geldiniz...";
    }

    @RequestMapping("/owners")
    public ModelAndView getOwners(){
        ModelAndView model = new ModelAndView();
        model.addObject("owners",petClinicService.findOwners());
        model.setViewName("owners");
        return model;
    }


}
