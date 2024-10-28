package com.example.exam.controller;


import com.example.exam.model.Employes;
import com.example.exam.repository.EmployesRepository;
import com.example.exam.services.EmplyesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employes")
public class EmployeController {

    @Autowired
    private EmplyesServices emplyesServices;

    @Autowired
    private EmployesRepository employesRepository;


    @PostMapping("/{lng}")
    public String addEmploye(@RequestBody Employes employe , @PathVariable String lng) {
        if (employesRepository.existsByEmail(employe.getEmail())) {
            if (lng.equals("EN")){
                return "Email already in use";}
            else {
                return "email deja utilise";
            }
        } else {
            emplyesServices.save(employe);
            if (lng.equals("EN")){
            return "Employee added successfully";}
            else {
                return "utilisateur bien ajoutee";
            }
        }
    }


    @GetMapping()
    public List<Employes> allEmployes() {
        return emplyesServices.getAllEmployes();
    }


    @PutMapping("/update/{id}/")
    public String updateStudent(@PathVariable Long id, @RequestBody Employes updatedEmploye) {
        Employes employes = emplyesServices.updateEmploye(id, updatedEmploye);
        if (employes != null) {
            return "Employee updated successfully";
        } else {
            return "Employee not found";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteEmploye(@PathVariable Long id) {
        if (emplyesServices.deleteEmploye(id)){
            return "Employee deleted successfully";
        } else {
            return "Employee not found";
        }
    }

}
