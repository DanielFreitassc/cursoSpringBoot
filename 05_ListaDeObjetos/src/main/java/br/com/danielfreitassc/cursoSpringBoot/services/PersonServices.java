package br.com.danielfreitassc.cursoSpringBoot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.danielfreitassc.cursoSpringBoot.models.Person;
@Service
public class PersonServices {
    
    private final AtomicLong counter =  new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    public List<Person> findAll(){

        logger.info("Procurando varias pessoas");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++){
          Person person = mockPerson(i);  
          persons.add(person);
        }
        return persons;
    }
    
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

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Address " + i);
        person.setGender("Male " + i);
        return person;
    }
}
