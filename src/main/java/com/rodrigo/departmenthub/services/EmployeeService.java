package com.rodrigo.departmenthub.services;

import com.rodrigo.departmenthub.entities.Employee;
import com.rodrigo.departmenthub.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository empRepository;

    @ReadOnlyProperty
    public List<Employee> findAll(){
        return empRepository.findAll();
    }

    @ReadOnlyProperty
    public Employee findById(Long id){
        return empRepository.findById(id).get();
    }

    @Transactional
    public Employee save(Employee emp){
        return empRepository.save(emp);
    }

    @Transactional
    public void delete(Long id){
        empRepository.deleteById(id);
    }

}
