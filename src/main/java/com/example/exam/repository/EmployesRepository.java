package com.example.exam.repository;


import com.example.exam.model.Employes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployesRepository extends JpaRepository<Employes, Integer> {


}
