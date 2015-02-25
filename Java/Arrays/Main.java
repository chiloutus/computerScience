import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		final int in[] = makeArray.mArray();
	


		Thread t = new Thread(new Runnable() {
		@Override
		public void run() {
			long startTime = System.currentTimeMillis();
			//array is final. copying array
			int[] sortedIn = in;
			//sort array
			for (int i = 1; i < sortedIn.length; i++) {
				int temp = sortedIn[i];
				int j;
				for (j = i - 1; j >= 0 && temp < sortedIn[j]; j--) {
					sortedIn[j + 1] = sortedIn[j];
					//System.out.print("We are now sorting/breaking the entire point");
				}
				sortedIn[j + 1] = temp;
			}
			
			long finishTime = System.currentTimeMillis();
			long time = finishTime-startTime;
			
			for(int i = 0; i < in.length; i++)
			{
				System.out.println(in[i]);
			}
			System.out.println("Time insertion sort took in milliseconds :" + time);
		}
		});
		
		
		t.start();
		

		}
}

