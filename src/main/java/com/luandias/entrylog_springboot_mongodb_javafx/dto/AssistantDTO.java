package com.luandias.entrylog_springboot_mongodb_javafx.dto;

import java.io.Serializable;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Assistant;

public class AssistantDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private Integer rg;
	private Integer cpf;
	private String birthdate;

	public AssistantDTO() {

	}

	public AssistantDTO(Assistant obj) {
		id = obj.getId();
		name = obj.getName();
		rg = obj.getRg();
		cpf = obj.getCpf();
		birthdate = obj.getBirthdate();
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

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

}
