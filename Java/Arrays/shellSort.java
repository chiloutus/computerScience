import java.io.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Vector;


public class shellSort {
	

	public static void sort(int[] in){
		int increment = in.length /2;
		//sort array
		while (increment > 0) {
			for (int i = increment; i < in.length; i++) {
				int j = i;
				int temp = in[i];
				while (j >= increment && in[j - increment] > temp) {
					in[j] = in[j - increment];
					j = j - increment;
				}
				in[j] = temp;
			}
			if (increment == 2) {
				increment = 1;
			} else {
				increment *= (5.0 / 11);
			}
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
                    int[] sortedIn = in;
                    sort(in);

                    long finishTime = System.currentTimeMillis();
                    long time = finishTime - startTime;
                    try (Writer writer = new PrintWriter(new BufferedWriter(new FileWriter("../../results.html", true)))) {
                        writer.write(" Java : ShellSort-Array:  " + time + "\n");
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
