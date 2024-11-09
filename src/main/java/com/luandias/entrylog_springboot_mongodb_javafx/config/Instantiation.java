package com.luandias.entrylog_springboot_mongodb_javafx.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Driver;
import com.luandias.entrylog_springboot_mongodb_javafx.repository.DriverRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private DriverRepository driverRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		driverRepository.deleteAll();
		
		Driver driver1 = new Driver(null, "Luan Dias", 111111, 111111, 111111, "2002-02-17");
		Driver driver2 = new Driver(null, "Felipe Santos", 222222, 222222, 222222, "1994-06-20");
		Driver driver3 = new Driver(null, "Paulo Jose", 333333, 333333, 333333, "1986-11-01");
	
		driverRepository.saveAll(Arrays.asList(driver1, driver2, driver3));
	}

}
