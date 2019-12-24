package tarea2;

public class Nodo {
	public Arbol arbol_izq;
	public Arbol arbol_der;
	private char dato;

	public Nodo() {
		this.arbol_der = null;
		this.arbol_izq = null;
		this.dato = ' ';
	}

	public char getDato() {
		return this.dato;
	}

	public void setDato(char dato) {
		this.dato = dato;
	}
}