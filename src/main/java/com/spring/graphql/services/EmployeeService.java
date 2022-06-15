package com.spring.graphql.services;

import com.spring.graphql.entities.Employee;
import com.spring.graphql.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Mono<Employee> getEmployees(final String employeeId) {
        return Mono.just(employeeId)
                .publishOn(Schedulers.boundedElastic())
                .map(this.employeeRepository::findById)
                .flatMap(value -> value.map(Mono::just)
                        .orElse(Mono.empty()));
    }

    public Mono<Employee> addEmployeeDetails(final Employee employee) {
        return Mono.just(employee)
                .publishOn(Schedulers.boundedElastic())
                .map(this.employeeRepository::save);
    }
}
