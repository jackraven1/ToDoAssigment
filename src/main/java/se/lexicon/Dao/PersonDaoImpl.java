package se.lexicon.Dao;

import se.lexicon.Person;
import se.lexicon.sequanser.PersonIdSequencer;

import java.util.ArrayList;
import java.util.Collection;

public class PersonDaoImpl implements PersonDAO{

    private ArrayList<Person> persons = new ArrayList<>();

    public PersonDaoImpl() {
    }

    @Override
    public Person persist(Person person) {
        int id= PersonIdSequencer.nextId();
        person=new Person(id,person.getFirstName(),person.getLastName(),person.getEmail());
        persons.add(person);
        return person;
    }

    @Override
    public Person findById(int id) {
        for(Person person:persons){
            if(person.getId()==id)
                return person;
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for(Person person : persons){
            if(person.getEmail().equals(email))
                return person;
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return persons;
    }

    @Override
    public void remove(int id) {
        persons.removeIf(person -> person.getId() == id);
    }
}
