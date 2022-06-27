package com.hospital;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.hospital.Entity.HospitalEntity;
import com.hospital.Repository.HospitalRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HospitalRepositoryTest {

	@BeforeEach
	void setUp() throws Exception {

	}

	@Autowired
	private HospitalRepository hospitalRepository;

	@Test
	@Order(1)
	public void saveHospitalTest() {
		HospitalEntity hospital = HospitalEntity.builder().hospitalName("Kauveri").hospitalAddress("Chennai")
				.hospitalContact("67896879").build();

		hospitalRepository.save(hospital);

		Assertions.assertThat(hospital.getHospitalId()).isGreaterThan(0);

	}

	@Test
	@Order(2)
	public void getHospitalByIdTest() {

		HospitalEntity hospital = hospitalRepository.findById(4).get();

		Assertions.assertThat(hospital.getHospitalId()).isEqualTo(4);
	}

	@Test
	@Order(3)
	public void getAllHospitalDetailsTest() {

		List<HospitalEntity> hospital = this.hospitalRepository.findAll();

		Assertions.assertThat(hospital.size()).isGreaterThan(0);
	}

	@Test
	@Order(4)
	public void updateHospitalTest() {

		HospitalEntity hospital = hospitalRepository.findById(4).get();

		hospital.setHospitalName("Unittas");

		HospitalEntity hospital1 = hospitalRepository.save(hospital);

		Assertions.assertThat(hospital1.getHospitalName()).isEqualTo("Unittas");

	}

	@Test
	@Order(5)

	public void deleteHospitalTest() {

		HospitalEntity hospital = hospitalRepository.findById(1).get();

		hospitalRepository.delete(hospital);

		HospitalEntity hospital1 = null;

		Optional<HospitalEntity> optionalHospitalEntity = hospitalRepository.findByhospitalName("Villi");

		if (optionalHospitalEntity.isPresent()) {
			hospital1 = optionalHospitalEntity.get();

		}

		Assertions.assertThat(hospital1 ).isNull();

	}

}
