package com.dam.dam2_2526_jdbc_gestores;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.stream.Stream;

public class Ficheros {
	
	public static Datos leerProperties(String gestor) throws FileNotFoundException, IOException {
		
		Properties gestores = new Properties();
		gestores.load(new FileInputStream("D:\\PRUEBAS\\gestores.properties"));
		
//		gestores.getProperty("driver"+gestor);
//		gestores.getProperty("ruta"+gestor);
//		gestores.getProperty("usuario"+gestor);
//		gestores.getProperty("password"+gestor);
		
		return new Datos(gestores.getProperty("driver"+gestor),
						 gestores.getProperty("ruta"+gestor),
						 gestores.getProperty("usuario"+gestor),
						 gestores.getProperty("password"+gestor));
	}
	
	public static void insertarEnBBDD(Datos datos, ArrayList<Departamento> departamentos) throws ClassNotFoundException, SQLException {
		
		Class.forName(datos.getDriver());
		 
		Connection conexion = DriverManager.getConnection(datos.getRuta(), datos.getUsuario(), datos.getPassword());
		
		PreparedStatement ps = conexion.prepareStatement("INSERT INTO departamento VALUES(?, ?, ?)");
		//Iteración de los valores a insertar
		for(Departamento depto: departamentos) {
			ps.setInt(1, depto.getCodigo());
			ps.setString(2, depto.getNombre());
			ps.setInt(3, depto.getNumEmpleados());
			
			ps.executeUpdate();
		}
		
	}
	
	public static ArrayList<Departamento> leerCSV(String ruta) throws IOException{
		
		ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
		
		//Leemos el CSV y rellenamos el ArrayList
		BufferedReader br = Files.newBufferedReader(Paths.get(ruta));
		Stream<String> lineas = br.lines();
		lineas.forEach(linea -> {
			String[] campos = linea.split(",");
			departamentos.add(new Departamento(Integer.parseInt(campos[0]), campos[1], Integer.parseInt(campos[2])));
		});
		
		return departamentos;
		
	}

}
