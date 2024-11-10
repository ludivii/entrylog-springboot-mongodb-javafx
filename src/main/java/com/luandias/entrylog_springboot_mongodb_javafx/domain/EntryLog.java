package com.luandias.entrylog_springboot_mongodb_javafx.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.enums.EntryStatus;

@Document(collection = "tb_entrylog")
public class EntryLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private LocalDateTime moment;
	private String company;
	private String cargo;
	private EntryStatus status;
	
	private Set<Driver> drivers = new HashSet<>();
	private Set<Assistant> assistants = new HashSet<>();
	private Set<Vehicle> vehicles = new HashSet<>();
	
	public EntryLog() {
		
	}

	public EntryLog(String id, LocalDateTime moment, String company, String cargo, EntryStatus status) {
		super();
		this.id = id;
		this.moment = moment;
		this.company = company;
		this.cargo = cargo;
		this.status = status;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntryLog other = (EntryLog) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
	
	
}
