package br.com.danielfreitassc.cursoSpringBoot.services;


import java.util.List;

import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielfreitassc.cursoSpringBoot.data.dto.v1.PersonDTO;
import br.com.danielfreitassc.cursoSpringBoot.exceptions.ResourceNotFoundException;
import br.com.danielfreitassc.cursoSpringBoot.mapper.DozerMapper;
import br.com.danielfreitassc.cursoSpringBoot.models.Person;
import br.com.danielfreitassc.cursoSpringBoot.repositories.PersonRepository;
@Service
public class PersonServices {
    
    
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;
    
    public List<PersonDTO> findAll(){

        logger.info("Procurando varias pessoas");

        return DozerMapper.parseListObjects(repository.findAll(), PersonDTO.class);
    }
    
    public PersonDTO findById(Long id){

        logger.info("Procurando uma pessoa");
   
        var entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerMapper.parseObject(entity, PersonDTO.class);
    }
    public PersonDTO create(PersonDTO person){

        logger.info("Criando uma pessoa");  
        var entity = DozerMapper.parseObject(person, Person.class);

        var dto = DozerMapper.parseObject(repository.save(entity), PersonDTO.class);
        return dto;
        
    }
    public PersonDTO update(PersonDTO person){

        logger.info("Atualizando uma pessoa");
        
        var entity = repository.findById(person.getId())
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

   
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var dto = DozerMapper.parseObject(repository.save(entity), PersonDTO.class);
        return dto;
    }
    public void delete(Long id){

        logger.info("Removendo uma pesoa");

        var entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
        
    }
  
}
