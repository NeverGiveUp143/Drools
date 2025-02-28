package com.drools.OrderLocation.models;

public class orderResponse<T> {
    public String message;
    public T data;
    public int httpStatus;

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}


	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	// Constructors, getters, and setters
    public orderResponse() {
    }

    public orderResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}