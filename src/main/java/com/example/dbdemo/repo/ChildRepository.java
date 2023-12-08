package com.example.dbdemo.repo;

import com.example.dbdemo.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * test 自動生成はできない…実装が無いからテストに使える情報が無いのか？
 */
@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
  List<Child> findByDummyId(Long dummyId);
}
