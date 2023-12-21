package com.example.dbdemo.repo;

import com.example.dbdemo.entity.Child;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {ChildRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.example.dbdemo.entity"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 自動生成時はこの行が無いのでDBアクセスに失敗して動かない。デフォルトの挙動をこれにする方法があればそのまま動くと思うのだが…
class ChildRepositoryDiffblueTest {
    @Autowired
    private ChildRepository childRepository;

    /**
     * Method under test: {@link ChildRepository#findByDummyId(Long)}
     */
    @Test
    void testFindByDummyId() {

        Child child = new Child();
        child.setDummyId(1L);
        child.setName("Name");
        child.setText("Text");

        Child child2 = new Child();
        child2.setDummyId(2L);
        child2.setName("com.example.dbdemo.entity.Child");
        child2.setText("com.example.dbdemo.entity.Child");
        childRepository.save(child);
        childRepository.save(child2);
        childRepository.findByDummyId(1L);
    }
}
