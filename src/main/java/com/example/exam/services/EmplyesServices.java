package com.example.exam.services;

import com.example.exam.model.Employes;
import com.example.exam.repository.EmployesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmplyesServices {

    @Autowired
    private EmployesRepository employesRepository;


    //Create
    public Boolean save(Employes employe) {
        Optional<Employes> optionalEmploye  = Optional.of(employesRepository.save(employe));
        if (optionalEmploye.isPresent()) {
            return true;
        }
        return false;
    }


    //Read
    public List<Employes> getAllEmployes() {
        return employesRepository.findAll();
    }


    //Update
    public Employes updateEmploye(Long id, Employes updatedEmploye) {
        Optional<Employes> optionalEmployes = employesRepository.findById(Math.toIntExact(id));
        if (optionalEmployes.isPresent()) {
            Employes existingEmploye= optionalEmployes.get();

            if (updatedEmploye.getFirstName() != null) {
                existingEmploye.setFirstName(updatedEmploye.getFirstName());
            }
            if (updatedEmploye.getLastName() != null) {
                existingEmploye.setLastName(updatedEmploye.getLastName());
            }
            if (updatedEmploye.getEmail() != null) {
                existingEmploye.setEmail(updatedEmploye.getEmail());
            }
            if (updatedEmploye.getPhone() != null) {
                existingEmploye.setPhone(updatedEmploye.getPhone());
            }
            if (updatedEmploye.getAge() != 0) {
                existingEmploye.setAge(updatedEmploye.getAge());
            }

            return employesRepository.save(existingEmploye);
        }
        return null;
    }

    //Delete
    public boolean deleteEmploye(Long id) {
        Optional<Employes> optionalEmploye = employesRepository.findById(Math.toIntExact(id));
        if (optionalEmploye.isPresent()) {
            Employes existingStudent = optionalEmploye.get();
            employesRepository.delete(existingStudent);
            return true;
        }
        return false;
    }


}
