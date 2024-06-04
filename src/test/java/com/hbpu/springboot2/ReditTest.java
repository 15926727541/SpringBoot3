package com.hbpu.springboot2;

import com.hbpu.springboot2.domain.Address;
import com.hbpu.springboot2.domain.Family;
import com.hbpu.springboot2.domain.Person;
import com.hbpu.springboot2.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReditTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void savePerson(){
        Person person = new Person("张","有才");
        Person person1 = new Person("Jame","Harden");
        Address address = new Address("北京","China");
        person.setAddress(address);

        List<Family> list = new ArrayList<>();
        Family dad = new Family("父亲","张良");
        Family mom = new Family("母亲","李香");
        list.add(dad);
        list.add(mom);
        person.setFamilyList(list);

        Person save = personRepository.save(person);
        Person save1 = personRepository.save(person1);
        System.out.println(save);
        System.out.println(save1);
    }

    @Test
    public void selsectPerson(){
        List<Person> personList = personRepository.findByLastname("有才");
        System.out.println(personList);
    }

    @Test
    public void updatePerson(){
        Person person = personRepository.findByFirstnameAndLastname("张","有才").get(0);
        person.setLastname("小明");
        Person update = personRepository.save(person);
        System.out.println(update);
    }

    @Test
    public void deletePerson(){
        Person person = personRepository.findByFirstnameAndLastname("张","小明").get(0);
        personRepository.delete(person);
    }
}
