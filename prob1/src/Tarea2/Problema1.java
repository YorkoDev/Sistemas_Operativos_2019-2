package tarea2;

import java.io.*;
import java.util.*;

public class Problema1 {

	public static void main(String[] args) {
		File file = new File("./funciones.txt");
		String[] line;
		try{
			Map<String,Funcion> mapita = new HashMap<String,Funcion>();
			Funcion funcion;
			Scanner input = new Scanner(file);
			int n = Integer.parseInt(input.nextLine());
			System.out.println(n);
			while(n > 0) {
				line = input.nextLine().split("=");
				funcion = new Funcion(line[1]);
				mapita.put(line[0], funcion);
				n--;
			}
			

		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
}


