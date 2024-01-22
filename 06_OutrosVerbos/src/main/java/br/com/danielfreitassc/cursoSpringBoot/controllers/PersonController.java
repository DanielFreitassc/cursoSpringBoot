package br.com.danielfreitassc.cursoSpringBoot.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)  // GET de todos os usuarios consome JSON
    public List<Person> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) // GET de um usuario consome JSON
    public Person findBtId(@PathVariable(value = "id") String id) {
        return service.findById(id);
    }

    @RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE) // Produz e consome JSON
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @RequestMapping(method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE) // Produz e consome JSON
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @RequestMapping(value = "/{id}",method=RequestMethod.DELETE) // Não Produz nem consome nada e é void ou seja sem retorno
    public void delete(@PathVariable(value = "id") String id) {

    }
}
          