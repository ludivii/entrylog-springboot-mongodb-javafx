package com.luandias.entrylog_springboot_mongodb_javafx.dto;

import java.io.Serializable;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Vehicle;
import com.luandias.entrylog_springboot_mongodb_javafx.domain.enums.Color;
import com.luandias.entrylog_springboot_mongodb_javafx.domain.enums.CarType;

public class VehicleDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private CarType carType;
	private String model;
	private String plate;
	private Color color;

	public VehicleDTO() {

	}

	public VehicleDTO(Vehicle obj) {
		id = obj.getId();
		carType = obj.getType();
		model = obj.getModel();
		plate = obj.getPlate();
		color = obj.getColor();
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

}
