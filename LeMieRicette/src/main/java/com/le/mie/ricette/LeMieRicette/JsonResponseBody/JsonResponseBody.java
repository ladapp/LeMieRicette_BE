package com.le.mie.ricette.LeMieRicette.JsonResponseBody;

public class JsonResponseBody {
	private int server;
	private Object response;
	private String jwt;
	
	public JsonResponseBody() {
		
	}
	public JsonResponseBody(int server, Object response, String jwt) {
		this.server = server;
		this.response = response;
		this.jwt = jwt;
	}
	public JsonResponseBody(int server, Object response) {
		this.server = server;
		this.response = response;
	}
	public int getServer() {
		return server;
	}
	public void setServer(int server) {
		this.server = server;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
}
