package com.envixo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.envixo.model.Midia;

@Repository
public interface MidiaRepository extends JpaRepository<Midia, Long>, JpaSpecificationExecutor<Midia> {

}