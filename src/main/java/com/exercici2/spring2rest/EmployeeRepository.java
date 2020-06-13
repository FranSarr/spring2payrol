package com.exercici2.spring2rest;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// TODO hacer que implementar el interfaz
interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select empleado from Employee empleado where empleado.getRole() like %?1")
    List<Employee> findByRole(Roles role);
}
