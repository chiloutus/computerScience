import java.util.Vector;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;



public class VectorShellSort {
	
	public static void sort(Vector<Integer> in){
		int increment = in.size() /2;
		//sort array
		while (increment > 0) {
			for (int i = increment; i < in.size(); i++) {
				int j = i;
				int temp = in.elementAt(i);
				while (j >= increment && in.elementAt(j - increment) > temp) {
					in.set(j,in.elementAt(j - increment));
					j = j - increment;
				}
				in.set(j,temp);
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
                    sort(in);
                    long finishTime = System.currentTimeMillis();
                    long time = finishTime - startTime;
                    try (Writer writer = new PrintWriter(new BufferedWriter(new FileWriter("../../results.html", true)))) {
                        writer.write("Java : ShellSort-Vector:  " + time + "\n");
                    } catch (IOException ex) {
                        // handle me
                    }
                }
            });


            t.start();

        }
    }


}
