package com.dam.dam2_2526_jdbc_gestores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * Hello world!
 *
 */
public class Principal 
{
	
    public static void main( String[] args ) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException
    {
    	int finalizar = -1;
		Scanner scan = new Scanner(System.in);
		String gestor = null;
		
		ArrayList<Departamento> departamentos = Ficheros.leerCSV("D:\\PRUEBAS\\departamentos.csv");
		Datos datos;
		
		while(finalizar!=0) {
			
			System.out.println("    MENÚ     ");
			System.out.println("1. MySQL");
			System.out.println("2. PostgreSQL");
			System.out.println("0. Salir");
			finalizar = scan.nextInt();
			
			
			switch (finalizar) {
			case 1: 
				 	gestor = "MySQL";
				 	datos = Ficheros.leerProperties(gestor);
					Ficheros.insertarEnBBDD(datos, departamentos);

					break;
					
			case 2: gestor = "Postgres";
					datos = Ficheros.leerProperties(gestor);
					Ficheros.insertarEnBBDD(datos, departamentos);

					break;
					
			case 0: System.out.println("Programa finalizado");
			        break;

			default: System.out.println("Opción no válida");
				
			}
			
			
		}
    }
}
