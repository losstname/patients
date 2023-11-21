package com.umrwhk.patients.jpa.repository;

import com.umrwhk.patients.jpa.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by umrwhk(umrwhk@gmail.com)
 */
@Repository
public interface PatientRepository  extends JpaRepository<Patient, Long> {
    Optional<Patient> findByPid(String pid);

    Page<Patient> findAllByPidContainingOrFirstNameContainingOrLastNameContaining(Pageable pageable, String pid, String firstName, String lastName);
}
