package com.hospital.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.Entity.DoctorEntity;
import com.hospital.Entity.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {

	List<PatientEntity> findByDoctor(DoctorEntity doctor);

	Optional<PatientEntity> findByPatientName(String patientName);

}
