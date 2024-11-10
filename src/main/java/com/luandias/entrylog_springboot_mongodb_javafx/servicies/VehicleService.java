package com.luandias.entrylog_springboot_mongodb_javafx.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Vehicle;
import com.luandias.entrylog_springboot_mongodb_javafx.dto.VehicleDTO;
import com.luandias.entrylog_springboot_mongodb_javafx.repository.VehicleRepository;
import com.luandias.entrylog_springboot_mongodb_javafx.servicies.exception.ObjectNotFoundException;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	public Vehicle findById(String id) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		return vehicle.orElseThrow(() -> new ObjectNotFoundException("Vehicle not found!"));
	}

	public Vehicle insert(Vehicle vehicle) {
		return vehicleRepository.insert(vehicle);
	}

	public void delete(String id) {
		findById(id);
		vehicleRepository.deleteById(id);
	}

	public Vehicle update(Vehicle vehicle) {
		Vehicle newVehicle = findById(vehicle.getId());
		updateData(newVehicle, vehicle);
		return vehicleRepository.save(newVehicle);
	}

	private void updateData(Vehicle newVehicle, Vehicle vehicle) {
		newVehicle.setType(vehicle.getType());
		newVehicle.setModel(vehicle.getModel());
		newVehicle.setPlate(vehicle.getPlate());
		newVehicle.setColor(vehicle.getColor());

	}

	public Vehicle fromDTO(VehicleDTO vehicleDTO) {
		return new Vehicle(vehicleDTO.getId(), vehicleDTO.getType(), vehicleDTO.getModel(), vehicleDTO.getPlate(),
				vehicleDTO.getColor());
	}
}
