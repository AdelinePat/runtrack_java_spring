package day3.day3.Service;
import day3.day3.Model.Person;
import day3.day3.Model.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person addPerson(String name, int age) {
        Person person = new Person(name, age);
        return personRepository.save(person);
    }

    public Optional<Person> updatePerson(Long id, String name, int age) {
        return personRepository.findById(id).map(person -> {
            person.setName(name);
            person.setAge(age);
            return personRepository.save(person);
        });
    }

    public void deletePerson(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
        }
    }
}
