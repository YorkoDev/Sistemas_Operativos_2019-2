package tarea2;

public class quick extends Thread
{

	int [] arr;
	int lower;
	int upper;
	public quick(int [] arr, int lower, int upper)
	{
		this.arr = arr;
		this.lower = lower;
		this.upper = upper;
	}

	public int miniordenar(int [] arr, int lower, int upper)
	{
		int pivote = arr[upper];
		int min = lower-1;
		for (int i = lower; i < upper ; i++) 
		{
			if (arr[i] < pivote) 
			{
				
				min++;
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}	
		}
		min++;
		int temp = arr[min]; 
        arr[min] = arr[upper]; 
        arr[upper] = temp;

        return min;

	}

	public void run()
	{
		if (lower < upper) 
		{
			int part = miniordenar(arr, lower, upper);	
			quick a = new quick(arr, lower, part-1);
			quick b = new quick(arr, part+1, upper);
			a.start();
			b.start();
		}

	}
}