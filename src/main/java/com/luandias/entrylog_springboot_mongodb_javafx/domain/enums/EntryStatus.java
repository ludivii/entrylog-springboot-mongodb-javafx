package com.luandias.entrylog_springboot_mongodb_javafx.domain.enums;

public enum EntryStatus {

	GRANTED(0), DENIED(1);

	private int code;

	private EntryStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static EntryStatus valueOf(int code) {
		for (EntryStatus status : EntryStatus.values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid Type Code");
	}

}
