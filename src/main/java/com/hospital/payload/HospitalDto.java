package com.hospital.payload;

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
public class HospitalDto {

	private int hospitalId;

	private String hospitalName;

	private String hospitalAddress;

	private String hospitalContact;

}
