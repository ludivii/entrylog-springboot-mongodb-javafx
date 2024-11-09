package com.luandias.entrylog_springboot_mongodb_javafx.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tb_driver")
public class Driver implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private Integer rg;
	private Integer cpf;
	private Integer cnh;
	private LocalDate birthdate;
	
	public Driver() {
		
	}

	public Driver(String id, String name, Integer rg, Integer cpf, Integer cnh, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.rg = rg;
		this.cpf = cpf;
		this.cnh = cnh;
		this.birthdate = birthdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Integer getCnh() {
		return cnh;
	}

	public void setCnh(Integer cnh) {
		this.cnh = cnh;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
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
		Driver other = (Driver) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
