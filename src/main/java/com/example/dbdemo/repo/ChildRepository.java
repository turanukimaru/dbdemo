package com.example.dbdemo.repo;

import com.example.dbdemo.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 */
@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
  List<Child> findByDummyId(Long dummyId);
}
