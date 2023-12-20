package com.example.dbdemo.repo;

import com.example.dbdemo.entity.Child;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {ChildRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.example.dbdemo.entity"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
class ChildRepositoryDiffblueTest {
    @Autowired
    private ChildRepository childRepository;

    /**
     * Method under test: {@link ChildRepository#findByDummyId(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByDummyId() {
        // TODO: Complete this test.
        //   Reason: R028 Incomplete repository information.
        //   Diffblue Cover cannot write tests because it wasn't able to fully understand
        //   your Spring Data Repository:
        //     Repository:  com.example.dbdemo.repo.ChildRepository
        //     Data Type:   com.example.dbdemo.entity.Child
        //     ID Type:     java.lang.Long
        //     ID Getter:
        //     Save Method: org.springframework.data.repository.CrudRepository.save(Object)
        //   Cover needs to understand the Data Type and the ID Type in order to write
        //   repository tests. Cover also needs an ID Getter method that gets the
        //   identifier field from a Data Type instance, this should be annotated @Id and
        //   be of type ID Type. Finally, better tests can be written if a Save Method
        //   is found taking a Data Type instance and storing it in the repository.
        //   Try extending CrudRepository with concrete type parameters, or if the class
        //   should not be considered a repository then annotate the class with the
        //   @NoRepositoryBean annotation.
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support/) providing details about this error.

        // Arrange
        // TODO: Populate arranged inputs
        Long dummyId = null;

        // Act
        List<Child> actualFindByDummyIdResult = this.childRepository.findByDummyId(dummyId);

        // Assert
        // TODO: Add assertions on result
    }
}
