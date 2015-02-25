import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;


public class InsertionSort {
	
	static void insert(int[] arr)
	{
	      int i, j, newValue;

	      for (i = 1; i < arr.length; i++) {

	            newValue = arr[i];

	            j = i;

	            while (j > 0 && arr[j - 1] > newValue) {

	                  arr[j] = arr[j - 1];

	                  j--;

	            }

	            arr[j] = newValue;

	      }

	}
	public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            final int in[] = makeArray.mArray();

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    long startTime = System.currentTimeMillis();
                    //array is final. copying array
                    insert(in);
                    long finishTime = System.currentTimeMillis();
                    long time = finishTime - startTime;
                    System.out.print("We are finished!");
                    try (Writer writer = new PrintWriter(new BufferedWriter(new FileWriter("../../results.html", true)))) {
                        writer.write("Java : InsertionSort-Array:  " + time + "\n");
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
