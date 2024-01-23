package br.com.danielfreitassc.cursoSpringBoot.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielfreitassc.cursoSpringBoot.data.dto.v1.PersonDTO;

import br.com.danielfreitassc.cursoSpringBoot.services.PersonServices;


@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices service;                         
     
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)  // GET de um usuario consome JSON
    public List<PersonDTO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) // GET de um usuario consome JSON
    public PersonDTO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE) // Produz e consome JSON
    public PersonDTO create(@RequestBody PersonDTO person) {
        return service.create(person);
    }

   @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE) // Produz e consome JSON
    public PersonDTO update(@RequestBody PersonDTO person) {
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}") // Não Produz nem consome nada e é void ou seja sem retorno
    public ResponseEntity<?> delete(@PathVariable(value = "id") PersonDTO person) {
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
          