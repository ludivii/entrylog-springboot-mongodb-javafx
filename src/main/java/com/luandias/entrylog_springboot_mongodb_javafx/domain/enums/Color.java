package com.luandias.entrylog_springboot_mongodb_javafx.domain.enums;

public enum Color {

	BLACK(0), WHITE(1), RED(2), YELLOW(3), BLUE(4), OTHER(5);

	private int code;

	private Color(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static Color valueOf(int code) {
		for (Color color : Color.values()) {
			if (color.getCode() == code) {
				return color;
			}
		}
		throw new IllegalArgumentException("Invalid Color Code");
	}

}
