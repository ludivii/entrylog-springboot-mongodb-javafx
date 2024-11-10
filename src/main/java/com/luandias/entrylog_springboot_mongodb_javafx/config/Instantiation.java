package com.luandias.entrylog_springboot_mongodb_javafx.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Assistant;
import com.luandias.entrylog_springboot_mongodb_javafx.domain.Driver;
import com.luandias.entrylog_springboot_mongodb_javafx.domain.Vehicle;
import com.luandias.entrylog_springboot_mongodb_javafx.domain.enums.Color;
import com.luandias.entrylog_springboot_mongodb_javafx.domain.enums.CarType;
import com.luandias.entrylog_springboot_mongodb_javafx.repository.AssistantRepository;
import com.luandias.entrylog_springboot_mongodb_javafx.repository.DriverRepository;
import com.luandias.entrylog_springboot_mongodb_javafx.repository.VehicleRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private AssistantRepository assistantRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		driverRepository.deleteAll();
		
		Driver driver1 = new Driver(null, "Luan Dias", 111111, 111111, 111111, "2002-02-17");
		Driver driver2 = new Driver(null, "Felipe Santos", 222222, 222222, 222222, "1994-06-20");
		Driver driver3 = new Driver(null, "Paulo Jose", 333333, 333333, 333333, "1986-11-01");
	
		driverRepository.saveAll(Arrays.asList(driver1, driver2, driver3));
		
		assistantRepository.deleteAll();
		
		Assistant assistant1 = new Assistant(null, "Pedro Silva", 121212, 121212, "2001-05-21");
		Assistant assistant2 = new Assistant(null, "Maria Lima", 232323, 232323, "1999-12-04");
		Assistant assistant3 = new Assistant(null, "Ricardo Ferreira", 343434, 343434, "1997-05-28");
		
		assistantRepository.saveAll(Arrays.asList(assistant1, assistant2, assistant3));
		
		vehicleRepository.deleteAll();
		
		Vehicle vehicle1 = new Vehicle(null, CarType.VAN, "MiniVan", "A11AAA1", Color.WHITE);
		Vehicle vehicle2 = new Vehicle(null, CarType.TRUCK, "Scania", "B22BBB2", Color.RED);
		Vehicle vehicle3 = new Vehicle(null, CarType.CAR, "Ford", "C33CCC3", Color.BLACK);
		
		vehicleRepository.saveAll(Arrays.asList(vehicle1, vehicle2, vehicle3));
		
		
	}

}
