package com.luandias.entrylog_springboot_mongodb_javafx.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Driver;
import com.luandias.entrylog_springboot_mongodb_javafx.dto.DriverDTO;
import com.luandias.entrylog_springboot_mongodb_javafx.servicies.DriverService;



@RestController
@RequestMapping(value = "/drivers")
public class DriverResource {

	@Autowired
	private DriverService driverService;

	@GetMapping
	public ResponseEntity<List<DriverDTO>> findAll() {
		List<Driver> list = driverService.findAll();
		List<DriverDTO> listDTO = list.stream().map(x -> new DriverDTO(x)).toList();
		return ResponseEntity.ok().body(listDTO);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{id}")
	public ResponseEntity DriverDTO(@PathVariable String id) {
		Driver driver = driverService.findById(id);		
		return ResponseEntity.ok().body(driver);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody DriverDTO driverDTO) {
		Driver driver = driverService.fromDTO(driverDTO);
		driver = driverService.insert(driver);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(driver.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
