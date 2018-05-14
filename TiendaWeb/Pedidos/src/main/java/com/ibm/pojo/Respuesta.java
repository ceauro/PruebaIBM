package com.ibm.pojo;

public class Respuesta {
	
	private boolean ok;
	private String errorUsuario;
	private String errorTecnico;
	
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public String getError() {
		return errorUsuario;
	}
	public void setError(String error) {
		this.errorUsuario = error;
	}
	public String getErrorTecnico() {
		return errorTecnico;
	}
	public void setErrorTecnico(String errorTecnico) {
		this.errorTecnico = errorTecnico;
	}
}
