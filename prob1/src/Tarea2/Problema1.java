package tarea2;

public class Problema1 {

	public static void main(String[] args) {
		Thread object = new Thread(new Funcion("f(x)=(1*2+3+4*5+asdas(x)*7*8)+jkxhaads(x)+10*(11+12)"));
		object.start();
	}
}


