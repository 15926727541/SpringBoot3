package com.hbpu.springboot2;

import com.hbpu.springboot2.domain.Discuss;
import com.hbpu.springboot2.domain.Person;
import com.hbpu.springboot2.repository.DiscussReqository;
import com.hbpu.springboot2.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class JPATest {
    @Autowired
    private DiscussReqository reqository;
    @Test
    public void selectComment(){
        List<Discuss> list = reqository.findByAuthorNotNull();
        System.out.println(list);
    }
    @Test
    public void selectCommentByExample(){
        Discuss discuss = new Discuss();
        discuss.setAuthor("张三");
        Example<Discuss> example = Example.of(discuss);
        List<Discuss> list = reqository.findAll(example);
        System.out.println(list);
    }
}
