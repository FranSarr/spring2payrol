package com.exercici2.spring2rest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface EmployeeRepository extends JpaRepository<Employee, Long> {
//TODO: no sé si hace falta esto:
//List<Employee> findbyRoles(Roles role);
//
}
