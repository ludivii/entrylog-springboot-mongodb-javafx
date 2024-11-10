package com.luandias.entrylog_springboot_mongodb_javafx.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Assistant;
import com.luandias.entrylog_springboot_mongodb_javafx.domain.Driver;
import com.luandias.entrylog_springboot_mongodb_javafx.domain.EntryLog;
import com.luandias.entrylog_springboot_mongodb_javafx.domain.Vehicle;
import com.luandias.entrylog_springboot_mongodb_javafx.domain.enums.EntryStatus;

public class EntryLogDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private LocalDateTime moment;
	private String company;
	private String cargo;
	private EntryStatus status;

	private Set<Driver> drivers = new HashSet<>();
	private Set<Assistant> assistants = new HashSet<>();
	private Set<Vehicle> vehicles = new HashSet<>();

	public EntryLogDTO() {

	}

	public EntryLogDTO(EntryLog obj) {
		id = obj.getId();
		moment = obj.getMoment();
		company = obj.getCompany();
		cargo = obj.getCargo();
		status = obj.getStatus();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public EntryStatus getStatus() {
		return status;
	}

	public void setStatus(EntryStatus status) {
		this.status = status;
	}

	public Set<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(Set<Driver> drivers) {
		this.drivers = drivers;
	}

	public Set<Assistant> getAssistants() {
		return assistants;
	}

	public void setAssistants(Set<Assistant> assistants) {
		this.assistants = assistants;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
