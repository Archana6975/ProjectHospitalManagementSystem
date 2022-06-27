package com.hospital.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.Entity.HospitalEntity;

public interface HospitalRepository extends JpaRepository<HospitalEntity, Integer> {

	Optional<HospitalEntity> findByhospitalName(String hospitalname);
}
