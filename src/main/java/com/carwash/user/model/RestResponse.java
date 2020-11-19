package com.carwash.user.model;

public class RestResponse {

	private String msg = "ok";
	private Object data;

	public RestResponse() {

	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RestResponse [msg=" + msg + ", data=" + data + "]";
	}

}
