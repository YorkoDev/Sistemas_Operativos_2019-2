package tarea2;

public class Arbol {
	public Nodo raiz;

	public Arbol() {
		this.raiz = new Nodo();
	}

	public void print() {
		if(this.raiz.arbol_izq != null){this.raiz.arbol_izq.print();}
		if(this.raiz.arbol_der != null){this.raiz.arbol_der.print();}
		System.out.println("---------");
		System.out.println(this.raiz.getDato());
	}
	
}