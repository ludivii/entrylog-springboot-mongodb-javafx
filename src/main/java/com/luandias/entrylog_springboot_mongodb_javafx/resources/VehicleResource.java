package com.luandias.entrylog_springboot_mongodb_javafx.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Vehicle;
import com.luandias.entrylog_springboot_mongodb_javafx.dto.VehicleDTO;
import com.luandias.entrylog_springboot_mongodb_javafx.servicies.VehicleService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleResource {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping
	public ResponseEntity<List<VehicleDTO>> findAll() {
		List<Vehicle> list = vehicleService.findAll();
		List<VehicleDTO> listDTO = list.stream().map(x -> new VehicleDTO(x)).toList();
		return ResponseEntity.ok().body(listDTO);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{id}")
	public ResponseEntity VehicleDTO(@PathVariable String id) {
		Vehicle vehicle = vehicleService.findById(id);
		return ResponseEntity.ok().body(vehicle);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody VehicleDTO vehicleDTO) {
		Vehicle vehicle = vehicleService.fromDTO(vehicleDTO);
		vehicle = vehicleService.insert(vehicle);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vehicle.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		vehicleService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody VehicleDTO vehicleDTO) {
		Vehicle vehicle = vehicleService.fromDTO(vehicleDTO);
		vehicle.setId(id);
		vehicle = vehicleService.update(vehicle);
		return ResponseEntity.noContent().build();
	}

}
