package tarea2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funcion implements Runnable {

	public Funcion(String funcion) {
		String array[] = funcion.split("=");
		String relevant = array[1];
		this.pline(relevant);
		this.parray(array);

		Pattern exp = Pattern.compile("[a-z]+");
		Matcher m = exp.matcher(relevant);
		System.out.println(m.start());

	}

	public void run() {
		try {
			System.out.println("Thread " + Thread.currentThread().getId() + " is running");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public void pline(String line) {
		System.out.println(line);
	}

	public void parray(String[] array) {
		for(int i = 0; i < array.length; i++) {
			this.pline(array[i]);
		}
	}
}