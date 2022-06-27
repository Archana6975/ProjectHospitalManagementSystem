package com.hospital.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.Entity.DoctorEntity;
import com.hospital.Entity.HospitalEntity;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {

	List<DoctorEntity> findByHospital(HospitalEntity hospital);

	Optional<DoctorEntity> findByDoctorName(String doctorName);

}
