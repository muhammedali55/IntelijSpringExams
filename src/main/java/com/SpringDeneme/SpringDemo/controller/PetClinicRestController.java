package com.SpringDeneme.SpringDemo.controller;

import com.SpringDeneme.SpringDemo.exception.InternalServerException;
import com.SpringDeneme.SpringDemo.exception.OwnerNotFoundException;
import com.SpringDeneme.SpringDemo.model.Owner;
import com.SpringDeneme.SpringDemo.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class PetClinicRestController {

    @Autowired
    private PetClinicService petClinicService;

    @RequestMapping(method = RequestMethod.GET,value = "/owners")
    public ResponseEntity<List<Owner>> getOwners(){
        List<Owner> owners = petClinicService.findOwners();
        return  ResponseEntity.ok(owners);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/owner")
    public ResponseEntity<List<Owner>> getOwners(@RequestParam("ln") String lastName){
        List<Owner> owners = petClinicService.findOwners(lastName);
        return ResponseEntity.ok(owners);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/owner/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable("id") Long id){
        try {
            Owner owner = petClinicService.findOwner(id);
            return  ResponseEntity.ok(owner);
        }catch (OwnerNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("/test")
    public String test(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Owner> result = restTemplate.getForEntity("http://localhost:8080/rest/owner/4",Owner.class);
        if(result!=null)
            return result.getBody().getFirstName();
        else
         return "ok";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/owner")
    public ResponseEntity<URI> createOwner(@RequestBody Owner owner){
        try {
            petClinicService.createOwner(owner);
            long id = owner.getId();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("/testekle")
    public ResponseEntity<URI> testEkle() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        Owner owner = new Owner();
        owner.setId(new Date().getTime());
        owner.setFirstName("Yeni Ekle Müşteri");
        owner.setLastName("Soyad66");
        restTemplate.postForLocation("http://localhost:8080/rest/owner",owner);
        URI location = new URI("http://localhost:8080/rest/owners");
        return  ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/owner/{id}")
    public ResponseEntity<?> updateOwner(@PathVariable("id") Long id, @RequestBody Owner ownerRequest){
        try {
            Owner owner = petClinicService.findOwner(id);
            owner.setLastName(ownerRequest.getLastName());
            owner.setFirstName(ownerRequest.getFirstName());
            petClinicService.updateOwner(owner);
            return  ResponseEntity.ok().build();
        }catch (OwnerNotFoundException ex){
            return  ResponseEntity.notFound().build();
        }catch (Exception ex){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("/update")
    public  String update(){
        Owner owner = new RestTemplate().getForObject("http://localhost:8080/rest/owner/4",Owner.class);
        owner.setFirstName("Değişen İsim");
        new RestTemplate().put("http://localhost:8080/rest/owner/4",owner);
        return "Ok";
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/owner/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable("id") Long id){
        try{
            petClinicService.deleteOwner(id);
            return ResponseEntity.ok().build();
        }catch (OwnerNotFoundException ex){
            throw  ex;
        }catch (Exception ex){
            throw new InternalServerException(ex);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/owner/{id}",produces = "application/json")
    public ResponseEntity<?> getOwnerAsHateoasResource(Long id){
        try {
            Owner owner = petClinicService.findOwner(id);
            Link self = ControllerLinkBuilder.linkTo(PetClinicRestController.class).slash("/owner/"+id).withSelfRel();
            Link create = ControllerLinkBuilder.linkTo(PetClinicRestController.class).slash("/owner/"+id).withRel("create");
            Link update = ControllerLinkBuilder.linkTo(PetClinicRestController.class).slash("/owner/"+id).withRel("update");
            Link delete = ControllerLinkBuilder.linkTo(PetClinicRestController.class).slash("/owner/"+id).withRel("delete");

            return  ResponseEntity.ok(owner);
        }catch (OwnerNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }


}
