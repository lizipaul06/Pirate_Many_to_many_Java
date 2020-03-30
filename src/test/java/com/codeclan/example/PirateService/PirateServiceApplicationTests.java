package com.codeclan.example.PirateService;

import com.codeclan.example.PirateService.models.Pirate;
import com.codeclan.example.PirateService.models.Raid;
import com.codeclan.example.PirateService.models.Ship;
import com.codeclan.example.PirateService.repositories.PirateRepository;
import com.codeclan.example.PirateService.repositories.RaidRepository;
import com.codeclan.example.PirateService.repositories.ShipRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PirateServiceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	//Spring created instance from that interface and have assess to all behaviours of interface

	@Test
	void contextLoads() {
	}



	@Test
	public void canCreatePirateAndShipAndRaid(){

		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);
		Pirate jack = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(jack);
		Raid raid = new Raid("Glasgow", 20);
		raidRepository.save(raid);

	}

	@Test
	public void canAddPirateToRaid(){
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);
		Pirate jack = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(jack);
		Raid raid = new Raid("Glasgow", 20);
		raid.addPirate(jack);
		raidRepository.save(raid);

	}

}
