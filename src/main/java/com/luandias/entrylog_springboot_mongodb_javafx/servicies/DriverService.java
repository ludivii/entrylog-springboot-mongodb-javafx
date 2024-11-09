package com.luandias.entrylog_springboot_mongodb_javafx.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Driver;
import com.luandias.entrylog_springboot_mongodb_javafx.dto.DriverDTO;
import com.luandias.entrylog_springboot_mongodb_javafx.repository.DriverRepository;
import com.luandias.entrylog_springboot_mongodb_javafx.servicies.exception.ObjectNotFoundException;

@Service
public class DriverService {

	@Autowired
	private DriverRepository driverRepository;
	
	public List<Driver> findAll(){
		return driverRepository.findAll();
	}
	
	public Driver findById(String id) {
		Optional<Driver> driver = driverRepository.findById(id);
		return driver.orElseThrow(() -> new ObjectNotFoundException("Driver not found!"));
	}
	
	public Driver insert(Driver driver) {
		return driverRepository.insert(driver);
	}
	
	public Driver fromDTO(DriverDTO driverDTO) {
		return new Driver(driverDTO.getId(), driverDTO.getName(), driverDTO.getRg(), driverDTO.getCpf(), driverDTO.getCnh(), driverDTO.getBirthdate());
	}
}
