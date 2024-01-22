package br.com.danielfreitassc.cursoSpringBoot.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.danielfreitassc.cursoSpringBoot.models.Person;
@Service
public class PersonServices {
    
    private final AtomicLong counter =  new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    
    public Person findById(String id){

        logger.info("Procurando uma pessoa");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Daniel");
        person.setLastName("Freitas");
        person.setAddress("Santa cataria");
        person.setGender("Male");
        return person;
    }
}
