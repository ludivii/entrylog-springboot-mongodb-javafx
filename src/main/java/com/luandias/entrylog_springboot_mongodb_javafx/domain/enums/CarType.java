package com.luandias.entrylog_springboot_mongodb_javafx.domain.enums;

public enum CarType {

	CAR(0), TRUCK(1), MOTORCYCLE(2), VAN(3);

	private int code;

	private CarType(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static CarType valueOf(int code) {
		for (CarType carType : CarType.values()) {
			if (carType.getCode() == code) {
				return carType;
			}
		}
		throw new IllegalArgumentException("Invalid CarType Code");
	}

}
