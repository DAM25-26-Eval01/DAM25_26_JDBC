package com.dam.dam2_2526_jdbc_gestores;

public class Departamento {
	
	private int codigo;
	private String nombre;
	private int numEmpleados;
	
	public Departamento(int codigo, String nombre, int numEmpleados) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.numEmpleados = numEmpleados;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumEmpleados() {
		return numEmpleados;
	}

	public void setNumEmpleados(int numEmpleados) {
		this.numEmpleados = numEmpleados;
	}
	
	

}
