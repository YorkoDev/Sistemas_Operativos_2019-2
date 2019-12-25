package tarea2;

public class printa
{
	public void printas(int [] arr)
	{
		System.out.print("[");
		System.out.print(arr[0]);
		for (int i = 1; i < arr.length ; i++ ) 
		{
			System.out.print(",");
			System.out.print(arr[i]);
		}
		System.out.print("]\n");

	}
}