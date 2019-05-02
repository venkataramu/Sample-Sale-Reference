package com.reference.SampleSaleReference.util;

public class Response{ 
	private String errorDescription;
	private Object data;
	
	public Response(String errorDescription, Object data) {
		this.errorDescription = errorDescription;
		this.data = data;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
