import java.util.Vector;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class VectorsQuickSort {
	
	public static void quickSort(Vector<Integer> arr, int low, int high) {
		 
		if (arr == null || arr.size() == 0)
			return;
 
		if (low >= high)
			return;
 
		//pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr.elementAt(middle);
 
		//make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr.elementAt(i) < pivot) {
				i++;
			}
 
			while (arr.elementAt(j) > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr.elementAt(i);
				arr.set(i,arr.elementAt(j));
				arr.setElementAt(j, temp);
				i++;
				j--;
			}
		}
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	
	}
	
	
		public static void main(String[] args) {
            for (int i = 0; i < 1; i++) {
                final Vector<Integer> in = GenerateVector.mVector();

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long startTime = System.currentTimeMillis();
                        //array is final. copying array
				/*for(int i = 0; i < in.size();i++)
				{
					System.out.println(in.elementAt(i));
				}*/
                        quickSort(in, 0, in.size() - 1);
                        long finishTime = System.currentTimeMillis();
                        long time = finishTime - startTime;
                        try (Writer writer = new PrintWriter(new BufferedWriter(new FileWriter("../../results.html", true)))) {
                            writer.write("Java : QuickSort-Vector:  " + time + "\n");
                        } catch (IOException ex) {
                            // handle me
                        }
                    }
                });


                t.start();


            }
        }

}
