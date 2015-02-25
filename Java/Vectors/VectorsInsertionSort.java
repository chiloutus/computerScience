import java.util.Vector;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;


public class VectorsInsertionSort {
	static void insert(Vector<Integer> arr)
	{
	      int i, j, newValue;

	      for (i = 1; i < arr.size(); i++) {

	            newValue = arr.elementAt(i);

	            j = i;

	            while (j > 0 && arr.elementAt(j - 1) > newValue) {

	                  arr.set(j,arr.elementAt(j - 1));
	                  j--;

	            }
	            arr.set(j,newValue);

	      }

	}
	
	
	
	
	
	public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            final Vector<Integer> in = GenerateVector.mVector();

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    long startTime = System.currentTimeMillis();
                    //array is final. copying array
                    Vector<Integer> sortedIn = in;
                    insert(sortedIn);
                    long finishTime = System.currentTimeMillis();
                    long time = finishTime - startTime;
                    try (Writer writer = new PrintWriter(new BufferedWriter(new FileWriter("../../results.html", true)))) {
                        writer.write("Java : InsertionSort-Vector:  " + time + "\n");
                    } catch (IOException ex) {
                        // handle me
                    }
                }
            });


            t.start();

        }
    }
}
