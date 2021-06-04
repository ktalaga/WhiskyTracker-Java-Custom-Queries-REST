package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetAllWhiskiesForParticularYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findByAge(2018);
		assertEquals(6, foundWhiskies.size());
	}

	@Test
	public void canGetDistilleriesByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findByRegion("Highland");
		assertEquals(3,foundDistilleries.size());
	}

	@Test
	public void canFindWhiskyByAgeAndDistilleryName(){
		List<Whisky> foundWhiskies = whiskyRepository.findByYearAndDistilleryName(15,"Glendronach");
		assertEquals(1, foundWhiskies.size());
	}

	@Test
	public void canFindAllWhiskiesFromRegion() {
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryRegion("Lowland");
		assertEquals(4, foundWhiskies.size());
	}

	@Test
	public void canFindAllDistilleriesWith12YearsOldWhiskies(){
		List<Distillery> foundDistilleries = distilleryRepository.findByWhiskiesYear(12);
		assertEquals(6, foundDistilleries.size());
	}
}
