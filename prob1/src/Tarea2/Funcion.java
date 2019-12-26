package tarea2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funcion implements Runnable {

	private String re = "\\(([0-9]+|[a-z]\\(x\\)|x)(\\+|\\-)([0-9]+|[a-z]+\\(x\\)|x)\\)";
	private Arbol arbolito;

	public Funcion(String funcion) {
		arbolito = new Arbol();
		Nodo aux;
		int pos;
		String sub;
		int[] arr;

		String array[] = funcion.split("=");
		String relevant = array[1];

		this.pline(relevant);
		
		arr = this.masAdentro(relevant);
		System.out.println(arr[0]+" "+arr[1]);
		sub = relevant.substring(arr[0],arr[1]+1);
		relevant = relevant.substring(0,arr[0])+"#"+relevant.substring(arr[1]+1,relevant.length());
		this.pline(sub);
		System.out.println("------");
		this.pline(relevant);

		pos = hayMultODiv(sub);
		if(pos != -1) {
			aux = new Nodo();
			aux.setDato(sub.charAt(pos));
			aux.arbol_izq = new Arbol();
			aux.arbol_izq.raiz.setDato(sub.charAt(pos-1));
			aux.arbol_der = new Arbol();
			aux.arbol_der.raiz.setDato(sub.charAt(pos+1));
			System.out.println(aux.arbol_izq.raiz.getDato()+""+aux.getDato()+""+aux.arbol_der.raiz.getDato());
			sub = sub.replaceFirst(aux.arbol_izq.raiz.getDato()+"\\"+aux.getDato()+""+aux.arbol_der.raiz.getDato(),"#");
			this.pline(sub);
		}
		
	}

	public int[] masAdentro(String funcion) {
		int[] xy = {-1,-1};
		int i;

		for(i = 0; i < funcion.length(); i++) {
			if(funcion.charAt(i) == '('){
				xy[0] = i; 
			}
			else if(funcion.charAt(i) == ')'){
				xy[1] = i;
				break;
			}
		}
		return xy;
	}


	public int hayMultODiv(String funcion) {
		int i;

		for(i = 0; i < funcion.length(); i++ ) {
			if(funcion.charAt(i) == '*' || funcion.charAt(i) == '/') {return i;}
		}
		return -1;
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