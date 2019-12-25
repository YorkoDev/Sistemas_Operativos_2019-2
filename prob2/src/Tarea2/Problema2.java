package tarea2;
import java.util.concurrent.TimeUnit;

public class Problema2 
{

	public static void main(String[] args) {
		 
		int [] arr = {7,4,3,6,5,2,10,9};
		int n = arr.length -1;
		//TimeUnit t = TimeUnit.SECONDS();
		printa pri = new printa();
		quick qs = new quick(arr, 0, n);
		qs.start();
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException ie)
		{
			Thread.currentThread().interrupt();
		}

		pri.printas(arr);
	}
}


