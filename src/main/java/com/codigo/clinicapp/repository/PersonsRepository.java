package com.codigo.clinicapp.repository;

import com.codigo.clinicapp.entity.PersonsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonsRepository extends JpaRepository<PersonsEntity, Integer> {
    boolean existsByNumDocument(String numDocument);
    Optional<PersonsEntity> findByNumDocument(String numDocument);
}

