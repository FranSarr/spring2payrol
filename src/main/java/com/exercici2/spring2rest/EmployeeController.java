package com.exercici2.spring2rest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.exercici2.spring2rest.Roles.*;

@RestController
class EmployeeController {
    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/employees")
    List<Employee> all() {
        return repository.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        switch (newEmployee.getRole()) {
            case MACHACA:
                newEmployee.setSalary(10000);
                break;
            case JARDINERO:
                newEmployee.setSalary(20000);
                break;
            case JEFE:
                newEmployee.setSalary(50000);
                break;
        }

        return repository.save(newEmployee);
    }


    //TODO Conseguir que busque por roles

   // @GetMapping("/employees/{role}")
   // List<Employee> perRoles (@PathVariable Roles role) {
   //     return repository.findByRoles(role)
   //             .orElseThrow(() -> new EmployeeNotFoundException(role));
   // }



    // Single item




    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
