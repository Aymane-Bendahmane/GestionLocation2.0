package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Bien;

public interface BienRepository extends JpaRepository<Bien, Long>{

}
