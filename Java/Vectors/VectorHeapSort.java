import java.util.Vector;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;


public class VectorHeapSort {
	
	
	private static Vector<Integer> a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    
    public static void buildheap(Vector<Integer> a){
        n=a.size()-1;
        for(int i=n/2;i>=0;i--){
            maxheap(a,i);
        }
    }
    
    public static void maxheap(Vector<Integer> a, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= n && a.elementAt(left) > a.elementAt(i)){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && a.elementAt(right) > a.elementAt(largest)){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            maxheap(a, largest);
        }
    }
    
    public static void exchange(int i, int j){
        int t=a.elementAt(i);
        a.set(i,a.elementAt(j));
        a.set(j,t);
        }
    
    public static void sort(Vector<Integer> a0){
        a=a0;
        buildheap(a);
        
        for(int i=n;i>0;i--){
            exchange(0, i);
            n=n-1;
            maxheap(a, 0);
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
                        writer.write("Java : HeapSort-Vector:  " + time + "\n");
                    } catch (IOException ex) {
                        // handle me
                    }
                }
            });


            t.start();

        }
    }



}
