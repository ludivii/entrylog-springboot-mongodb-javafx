package com.luandias.entrylog_springboot_mongodb_javafx.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Driver;
import com.luandias.entrylog_springboot_mongodb_javafx.dto.DriverDTO;
import com.luandias.entrylog_springboot_mongodb_javafx.servicies.DriverService;

@RestController
@RequestMapping(value = "/drivers")
public class DriverResource {

	@Autowired
	private DriverService driverService;
	
	@GetMapping
	public ResponseEntity<List<DriverDTO>> findAll(){
		List<Driver> list = driverService.findAll();
		List<DriverDTO> listDTO = list.stream().map(x -> new DriverDTO(x)).toList();
		return ResponseEntity.ok().body(listDTO);
	}

}
