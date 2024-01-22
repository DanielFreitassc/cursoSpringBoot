package br.com.danielfreitassc.cursoSpringBoot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielfreitassc.cursoSpringBoot.exceptions.ResourceNotFoundException;
import br.com.danielfreitassc.cursoSpringBoot.models.Person;
import br.com.danielfreitassc.cursoSpringBoot.repositories.PersonRepository;
@Service
public class PersonServices {
    
    
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;
    
    public List<Person> findAll(){

        logger.info("Procurando varias pessoas");

        return repository.findAll();
    }
    
    public Person findById(Long id){

        logger.info("Procurando uma pessoa");
   
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }
    public Person create(Person person){

        logger.info("Criando uma pessoa");  

        return repository.save(person);
    }
    public Person update(Person person){

        logger.info("Atualizando uma pessoa");
        
        var entity = repository.findById(person.getId())
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

   
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }
    public void delete(Long id){

        logger.info("Removendo uma pesoa");

        var entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
        
    }
  
}
