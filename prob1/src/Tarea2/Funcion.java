package tarea2;

import java.util.LinkedList;

public class Funcion implements Runnable {

	public Arbol arbolito;

	public Funcion(String funcion) {
		this.arbolito = new Arbol();
		funcion = reemplazando_f(funcion);
		this.arbolito = this.ayuda_esta_funcion_la_hice_a_las_4am_y_entro_a_trabajar_a_las_9_30(funcion);

	}

	public Arbol ayuda_esta_funcion_la_hice_a_las_4am_y_entro_a_trabajar_a_las_9_30(String funcion) {
		Arbol returne = new Arbol();
		String sub;
		int pos, pos_izq, pos_der;
		LinkedList<Arbol> bosque = new LinkedList<Arbol>();
		int[] arr = this.masAdentro(funcion);

		while(arr[0] != -1 && arr[1] != -1) {
			sub = funcion.substring(arr[0]+1,arr[1]);

			bosque.add(ayuda_esta_funcion_la_hice_a_las_4am_y_entro_a_trabajar_a_las_9_30(sub));
			funcion = funcion.substring(0,arr[0])+"#"+funcion.substring(arr[1]+1,funcion.length());
			arr = this.masAdentro(funcion);
		}

		pos = this.hayMultODiv(funcion);
		while(pos != -1) {
			Nodo nodo = new Nodo();

			nodo.setDato(""+funcion.charAt(pos));
			if(funcion.charAt(pos-1) == '#' && funcion.charAt(pos+1) == '#') {
				pos_izq = pos-1; pos_der = pos+2;
				nodo.arbol_izq = bosque.get(quienSoy(funcion, pos-1));
				nodo.arbol_der = bosque.get(quienSoy(funcion, pos));
				bosque.remove(quienSoy(funcion, pos-1));
				bosque.remove(quienSoy(funcion, pos+1)-1);
			}
			else if(funcion.charAt(pos-1) != '#' && funcion.charAt(pos+1) == '#') {
				pos_der = pos+2; pos_izq = cuantosCharIzq(funcion,pos)+1;
				nodo.arbol_izq = new Arbol();
				nodo.arbol_izq.raiz.setDato(funcion.substring(pos_izq,pos));
				nodo.arbol_der = bosque.get(quienSoy(funcion, pos));
				bosque.remove(quienSoy(funcion, pos+1));
			}
			else if(funcion.charAt(pos-1) == '#' && funcion.charAt(pos+1) != '#') {
				pos_izq = pos-1; pos_der = cuantosCharDer(funcion,pos);
				nodo.arbol_der = new Arbol();
				nodo.arbol_der.raiz.setDato(funcion.substring(pos+1,pos_der));
				nodo.arbol_izq = bosque.get(quienSoy(funcion, pos-1));
				bosque.remove(quienSoy(funcion, pos-1));
			}
			else {
				pos_izq = cuantosCharIzq(funcion,pos)+1; pos_der = cuantosCharDer(funcion,pos);
				nodo.arbol_izq = new Arbol();
				nodo.arbol_izq.raiz.setDato(funcion.substring(pos_izq,pos));
				nodo.arbol_der = new Arbol();
				nodo.arbol_der.raiz.setDato(funcion.substring(pos+1,pos_der));
			}
			Arbol aux = new Arbol();
			aux.raiz = nodo;
			funcion = funcion.substring(0,pos_izq)+"#"+funcion.substring(pos_der,funcion.length());

			if(bosque.size() == 0){bosque.add(aux);}
			else if(quienSoy(funcion,pos_izq) == bosque.size()){bosque.add(aux);}
			else{bosque.add(quienSoy(funcion,pos_izq+1),aux);}
			pos = this.hayMultODiv(funcion);
		}


		pos = this.hayAddOSus(funcion);
		while(pos != -1) {
			Nodo nodo = new Nodo();

			nodo.setDato(""+funcion.charAt(pos));
			if(funcion.charAt(pos-1) == '#' && funcion.charAt(pos+1) == '#') {
				pos_izq = pos-1; pos_der = pos+2;
				nodo.arbol_izq = bosque.get(quienSoy(funcion, pos-1));
				nodo.arbol_der = bosque.get(quienSoy(funcion, pos));
				bosque.remove(quienSoy(funcion, pos-1));
				bosque.remove(quienSoy(funcion, pos+1)-1);
			}
			else if(funcion.charAt(pos-1) != '#' && funcion.charAt(pos+1) == '#') {
				pos_der = pos+2; pos_izq = cuantosCharIzq(funcion,pos)+1;
				nodo.arbol_izq = new Arbol();
				nodo.arbol_izq.raiz.setDato(funcion.substring(pos_izq,pos));
				nodo.arbol_der = bosque.get(quienSoy(funcion, pos));
				bosque.remove(quienSoy(funcion, pos+1));
			}
			else if(funcion.charAt(pos-1) == '#' && funcion.charAt(pos+1) != '#') {
				pos_izq = pos-1; pos_der = cuantosCharDer(funcion,pos);
				nodo.arbol_der = new Arbol();
				nodo.arbol_der.raiz.setDato(funcion.substring(pos+1,pos_der));
				nodo.arbol_izq = bosque.get(quienSoy(funcion, pos-1));
				bosque.remove(quienSoy(funcion, pos-1));
			}
			else {
				pos_izq = cuantosCharIzq(funcion,pos)+1; pos_der = cuantosCharDer(funcion,pos);

				nodo.arbol_izq = new Arbol();
				nodo.arbol_izq.raiz.setDato(funcion.substring(pos_izq,pos));
				nodo.arbol_der = new Arbol();
				nodo.arbol_der.raiz.setDato(funcion.substring(pos+1,pos_der));
			}
			Arbol aux = new Arbol();
			aux.raiz = nodo;
			funcion = funcion.substring(0,pos_izq)+"#"+funcion.substring(pos_der,funcion.length());

			if(bosque.size() == 0){bosque.add(aux);}
			else if(quienSoy(funcion,pos_izq+1) == bosque.size()){bosque.add(aux);}
			else{bosque.add(quienSoy(funcion,pos_izq+1),aux);}
			pos = this.hayAddOSus(funcion);
		}

		returne = bosque.get(0);
		return returne;
	}

	public String reemplazando_f(String funcion) {
		int i = 0;
		int inicio, termino;
		while(true){
			if(i < funcion.length() && funcion.charAt(i) != '+' && funcion.charAt(i) != 'x' && funcion.charAt(i) != '-' && funcion.charAt(i) != '*' && funcion.charAt(i) != '/' && funcion.charAt(i) != '1' && funcion.charAt(i) != '2' && funcion.charAt(i) != '3' && funcion.charAt(i) != '4' && funcion.charAt(i) != '5' && funcion.charAt(i) != '6' && funcion.charAt(i) != '7' && funcion.charAt(i) != '8' && funcion.charAt(i) != '9' && funcion.charAt(i) != '0' && funcion.charAt(i) != '(' && funcion.charAt(i) != ')'){
				inicio = i;
				while(i <= funcion.length()-1 && funcion.charAt(i) != '+' && funcion.charAt(i) != '-' && funcion.charAt(i) != '*' && funcion.charAt(i) != '/' && funcion.charAt(i) != '1' && funcion.charAt(i) != '2' && funcion.charAt(i) != '3' && funcion.charAt(i) != '4' && funcion.charAt(i) != '6' && funcion.charAt(i) != '7' && funcion.charAt(i) != '8' && funcion.charAt(i) != '9' && funcion.charAt(i) != '0'){
					i++;
				}
				termino = i;
				funcion = funcion.substring(0,inicio)+funcion.substring(inicio,termino-3)+funcion.substring(termino,funcion.length());
				i = termino-3;
				if(i == funcion.length()) break;
			}
			i++;
			if(i == funcion.length()) break;

			
		}
		return funcion;
	}

	public int cuantosCharIzq(String funcion, int pos){
		int i;
		for(i = pos-1; i >= 0 && funcion.charAt(i) != '+' && funcion.charAt(i) != '-' && funcion.charAt(i) != '*' && funcion.charAt(i) != '/'; i--){}
		return i;
	}

	public int cuantosCharDer(String funcion, int pos){
		int i;
		for(i = pos+1; i < funcion.length() && funcion.charAt(i) != '+' && funcion.charAt(i) != '-' && funcion.charAt(i) != '*' && funcion.charAt(i) != '/'; i++){}
		return i;
	}

	public int quienSoy(String funcion, int pos) {
		int i, cont;
		cont = 0;
		for(i = 0; i < pos; i++) {
			if(funcion.charAt(i) == '#') cont++;
		}
		return cont;
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

	public int hayAddOSus(String funcion) {
		int i;

		for(i = 0; i < funcion.length(); i++ ) {
			if(funcion.charAt(i) == '+' || funcion.charAt(i) == '-') {return i;}
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