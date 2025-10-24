package com.dam.dam2_2526_jdbc_gestores;

public class Datos {
	
	private String driver;
	private String ruta;
	private String usuario;
	private String password;
	
	public Datos(String driver, String ruta, String usuario, String password) {
		this.driver = driver;
		this.ruta = ruta;
		this.usuario = usuario;
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
