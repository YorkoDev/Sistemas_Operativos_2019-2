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

	public void run()
	{

		int c = lower;
		int k = upper;
		int pivote = arr[(lower+upper)/2];
		while(c<k)
		{

			while(arr[k] < pivote) k--;
			while(arr[c] > pivote) c++;
		
			if (c <= k)
			{
				int temp = arr[c];
				arr[c] = arr[k];
				arr[k]= temp;
				k--;
				c++;
			}
			if (lower < k) 
			{
				quick a = new quick(arr, lower, k);
				a.start();
				/*try{
					a.join();
				}
				catch(InterruptedException ie)
				{
					 Thread.currentThread().interrupt();
				}*/		
			}
			if (c < upper) 
			{
				quick b = new quick(arr, c, upper);		
				b.start();
				/*try{
					b.join();
				}
				catch(InterruptedException ie)
				{
					 Thread.currentThread().interrupt();
				}*/
			}	
		}
	}
}