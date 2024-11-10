package com.luandias.entrylog_springboot_mongodb_javafx.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.enums.Color;
import com.luandias.entrylog_springboot_mongodb_javafx.domain.enums.CarType;

@Document(collection = "tb_vehicle")
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private CarType carType;
	private String model;
	private String plate;
	private Color color;

	public Vehicle() {

	}

	public Vehicle(String id, CarType carType, String model, String plate, Color color) {
		super();
		this.id = id;
		this.carType = carType;
		this.model = model;
		this.plate = plate;
		this.color = color;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CarType getType() {
		return carType;
	}

	public void setType(CarType carType) {
		this.carType = carType;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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
		Vehicle other = (Vehicle) obj;
		return Objects.equals(id, other.id);
	}

}
