package br.com.danielfreitassc.cursoSpringBoot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import br.com.danielfreitassc.cursoSpringBoot.models.Person;
import br.com.danielfreitassc.cursoSpringBoot.services.PersonServices;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;                         // << Com injeção
    // private PersonServices services = new PersonServices(); << Sem injeção
   
    @RequestMapping(value = "/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
    public Person findBtId(@PathVariable(value = "id") String id) throws Exception{
        return service.findById(id);
    }

    
}
          