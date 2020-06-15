package com.exercici2.spring2rest;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select empleado from Employee empleado where empleado.role = :role")
    List<Employee> findByRole(Roles role);
}
