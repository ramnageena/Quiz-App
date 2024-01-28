package com.quiz.app.exception;

public class ResourceNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String fieldName;
	private long filedValue;
	public ResourceNotFoundException(String resourceName, String fieldName, long filedValue) {
		super(String.format("%s not found with %s : %s",resourceName,fieldName,filedValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.filedValue = filedValue;
	}
	
	

}
