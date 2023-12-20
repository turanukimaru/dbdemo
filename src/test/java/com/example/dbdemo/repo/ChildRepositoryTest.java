package com.example.dbdemo.repo;

import com.example.dbdemo.entity.Child;
import jakarta.persistence.EntityManager;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ContextConfiguration(classes = {ChildRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.example.dbdemo.entity"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class ChildRepositoryTest {
    @Autowired
    ChildRepository childRepository;
    @Autowired
    EntityManager entityManager;
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String user;
    @Value("${spring.datasource.password}")
    String pass;

    @BeforeEach
    public void setUp() {
        Flyway flyway = Flyway.configure().dataSource(url, user, pass).load();
        flyway.migrate();
    }

    @Test
    void findByDummyId() {
        List<Child> children = childRepository.findByDummyId(Integer.MAX_VALUE + 1L);
        System.out.println(children);
        assertThat(children.size()).isEqualTo(0);
    }
}