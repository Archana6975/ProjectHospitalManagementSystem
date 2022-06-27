package com.hospital.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.Entity.MedicalRecordEntity;
import com.hospital.Entity.PatientEntity;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecordEntity, Integer> {

	List<MedicalRecordEntity> findByPatient(PatientEntity patient);

	Optional<MedicalRecordEntity> findByDateOfAdmission(String dateOfAdmission);
}
