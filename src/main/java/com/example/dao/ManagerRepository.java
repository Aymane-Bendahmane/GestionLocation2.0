package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long>{

}
