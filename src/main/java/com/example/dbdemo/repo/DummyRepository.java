package com.example.dbdemo.repo;

import com.example.dbdemo.entity.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyRepository extends JpaRepository<Dummy,Long> {
}
