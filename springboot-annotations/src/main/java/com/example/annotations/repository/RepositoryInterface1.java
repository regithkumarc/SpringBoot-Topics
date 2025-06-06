package com.example.annotations.repository;

import com.example.annotations.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInterface1 extends JpaRepository<Employee,Integer> {

}
