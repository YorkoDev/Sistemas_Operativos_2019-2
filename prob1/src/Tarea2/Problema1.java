package tarea2;

public class Problema1 {

	public static void main(String[] args) {
		Thread object = new Thread(new Funcion("f(x)=(1+(3*(4+2+(1+2*4+2))))*(3+5)"));
		object.start();
	}
}


