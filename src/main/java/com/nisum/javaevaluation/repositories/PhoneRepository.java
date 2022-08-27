package com.nisum.javaevaluation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nisum.javaevaluation.models.Phone;

public interface PhoneRepository extends JpaRepository<Phone, String> {

}
