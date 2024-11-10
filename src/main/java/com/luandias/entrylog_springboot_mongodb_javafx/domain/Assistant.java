package com.luandias.entrylog_springboot_mongodb_javafx.domain;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tb_assistant")
public class Assistant implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private Integer rg;
	private Integer cpf;
	private String birthdate;

	public Assistant() {

	}

	public Assistant(String id, String name, Integer rg, Integer cpf, String birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.rg = rg;
		this.cpf = cpf;
		this.birthdate = birthdate.formatted(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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
		Assistant other = (Assistant) obj;
		return Objects.equals(id, other.id);
	}

}
