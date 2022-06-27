package com.hospital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.Exception.ApiResponse;
import com.hospital.Service.HospitalService;
import com.hospital.payload.HospitalDto;

@RestController
@RequestMapping("/api")
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;

	// To create a Hospital Record
	@PostMapping("/SaveHospital")
	public ResponseEntity<HospitalDto> createHospital(@Valid @RequestBody HospitalDto hospital) {
		HospitalDto createdhospital = this.hospitalService.createHospital(hospital);

		return new ResponseEntity<HospitalDto>(createdhospital, HttpStatus.CREATED);

	}

	// To fetch all Hospital Record
	@GetMapping("/hospital")
	public ResponseEntity<List<HospitalDto>> getAllHospital() {
		List<HospitalDto> allHospital = this.hospitalService.getAllHospital();
		return new ResponseEntity<List<HospitalDto>>(allHospital, HttpStatus.OK);

	}

	// To fetch hospital record by Id
	@GetMapping("/hospital/{hospitalId}")
	public ResponseEntity<HospitalDto> getHospitalById(@PathVariable int hospitalId) {
		HospitalDto hospitalDto = this.hospitalService.getHospitalById(hospitalId);

		return new ResponseEntity<HospitalDto>(hospitalDto, HttpStatus.OK);

	}

	// To update hospital record by Id
	@PutMapping("/hospital/{hospitalId}")
	public ResponseEntity<HospitalDto> updateHospitalById(@RequestBody HospitalDto hospital,
			@PathVariable int hospitalId) {
		HospitalDto hospitalDto = this.hospitalService.updateHospitalById(hospital, hospitalId);
		return new ResponseEntity<HospitalDto>(hospitalDto, HttpStatus.OK);

	}

	// To delete hospital record by Id
	@DeleteMapping("hospital/{hospitalId}")
	public ResponseEntity<ApiResponse> deleteHospitalById(@PathVariable int hospitalId) {

		this.hospitalService.deleteHospitalById(hospitalId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Hospital Detail is deleted successfully", true),
				HttpStatus.OK);
	}

}
