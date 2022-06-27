package com.hospital.payload;

import java.util.List;

import com.hospital.Entity.HospitalEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DoctorDto {

	private int doctorid;

	private String doctorName;

	private String designation;

	private String doctorSalary;

	private HospitalDto hospital;

	// private List<PatientDto> patientDto;

}
