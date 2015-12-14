package org.doando.exception;

public class InvallidEmailOrCnpjException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8316433388686609170L;

	public InvallidEmailOrCnpjException(String message) {
		super(message);
	}
	
	public InvallidEmailOrCnpjException(Throwable t) {
		super(t);
	}
}
