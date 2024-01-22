package br.com.danielfreitassc.cursoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.danielfreitassc.cursoSpringBoot.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{ 
    
}
// Só isso já é suficiente para que o Spring Data JPA crie uma implementação padrão para essa interface. 
// Essa implementação padrão será injetada automaticamente pelo Spring no nosso controller.