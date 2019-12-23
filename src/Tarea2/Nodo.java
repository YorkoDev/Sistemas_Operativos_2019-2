package tarea2;

public class Nodo {
	private Arbol arbol_izq;
	private Arbol arbol_der;
	private char dato;

	public void Nodo() {
		this.arbol_der = null;
		this.arbol_izq = null;
		this.dato = ' ';
	}

	public Arbol getArbolIzq() {
		return this.arbol_izq;
	}

	public void setArbolIzq(Arbol arbol_izq) {
		this.arbol_izq = arbol_izq;
	}

	public Arbol getArbolDer() {
		return this.arbol_der;
	}

	public void setArbolDer(Arbol arbol_der) {
		this.arbol_der = arbol_der;
	}

	public char getDato() {
		return this.dato;
	}

	public void setDato(char dato) {
		this.dato = this.dato;
	}
}