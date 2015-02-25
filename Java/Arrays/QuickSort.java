import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
public class QuickSort {
	
	public static void quickSort(int[] arr, int low, int high) {
		 
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		//pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		//make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		//recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
	
	 public static void main(String[] args) {
         for (int i = 0; i < 1; i++) {

             final int in[] = makeArray.mArray();

             Thread t = new Thread(new Runnable() {
                 @Override
                 public void run() {
                     long startTime = System.currentTimeMillis();
                     //array is final. copying array
                     quickSort(in, 0, in.length - 1);
                     long finishTime = System.currentTimeMillis();
                     long time = finishTime - startTime;
                     try (Writer writer = new PrintWriter(new BufferedWriter(new FileWriter("../../results.html", true)))) {
                         writer.write("Java : QuickSort-Array:  " + time + "\n");
                         writer.close();
                     } catch (IOException ex) {
                         // handle me
                     }
                 }
             });


             t.start();

         }
     }

}
