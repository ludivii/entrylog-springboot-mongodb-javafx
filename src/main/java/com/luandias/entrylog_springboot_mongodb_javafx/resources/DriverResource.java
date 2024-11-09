package com.luandias.entrylog_springboot_mongodb_javafx.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Driver;

@RestController
@RequestMapping(value = "/drivers")
public class DriverResource {
	
	@GetMapping
	public ResponseEntity<List<Driver>> findAll(){
		Driver luan = new Driver("1", "Luan Dias", 111111, 111111, 111111, new Date());
		Driver paulo = new Driver("2", "Paulo Jose", 222222, 222222, 222222, new Date());
		List<Driver> list = new ArrayList<>();
		list.addAll(Arrays.asList(luan,paulo));
		return ResponseEntity.ok().body(list);
	}

}
