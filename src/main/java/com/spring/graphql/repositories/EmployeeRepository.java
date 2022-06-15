package com.spring.graphql.repositories;

import com.spring.graphql.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> findAllByLocation(String location);
}
