package com.luandias.entrylog_springboot_mongodb_javafx.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Driver;
import com.luandias.entrylog_springboot_mongodb_javafx.repository.DriverRepository;

@Service
public class DriverService {

	@Autowired
	private DriverRepository driverRepository;
	
	public List<Driver> findAll(){
		return driverRepository.findAll();
	}
}
