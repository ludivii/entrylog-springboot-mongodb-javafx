package com.luandias.entrylog_springboot_mongodb_javafx.servicies.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
