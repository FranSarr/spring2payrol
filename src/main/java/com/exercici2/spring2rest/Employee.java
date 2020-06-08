package com.exercici2.spring2rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
class Employee {
    private @Id @GeneratedValue Long id;
    private String name;
    private Roles role;
    private long salary;

    Employee() {}

    Employee(String name, Roles role) {

        this.name = name;
        this.role = role;

        // TODO Conseguir que enseñe en la salida el cxampo salary
        this.salary = 100000;

    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Roles getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
                && Objects.equals(this.role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

   @Override
   public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + ", salary='" + this.salary + '\'' + '}';
    }
}
