package com.hospital.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "patientrecord")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PatientEntity {

	@Id
	@SequenceGenerator(name="patient",initialValue=301,sequenceName = "patient")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;

	@Column(nullable = false)
	private String patientName;

	@Column(nullable = false)

	private String patientAge;

	@Column(nullable = false)

	private String patientDiagnosis;

	@Column(nullable = false)

	private String patientAddress;

	@ManyToOne
	private DoctorEntity doctor;

	@OneToMany(cascade = CascadeType.ALL)
	private List<MedicalRecordEntity> medicalRecordEntity = new ArrayList<MedicalRecordEntity>();
}
