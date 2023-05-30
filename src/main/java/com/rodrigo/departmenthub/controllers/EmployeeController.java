package com.rodrigo.departmenthub.controllers;

import com.rodrigo.departmenthub.entities.Employee;
import com.rodrigo.departmenthub.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {

    private final EmployeeService empService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(empService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){
        return ResponseEntity.ok(empService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
        return new ResponseEntity<>(empService.save(emp), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        empService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

