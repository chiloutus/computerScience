import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
public class HeapSort 
{
    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    
    public static void buildheap(int []a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--){
            maxheap(a,i);
        }
    }
    
    public static void maxheap(int[] a, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= n && a[left] > a[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && a[right] > a[largest]){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            maxheap(a, largest);
        }
    }
    
    public static void exchange(int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t; 
        }
    
    public static void sort(int []a0){
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
            final int in[] = makeArray.mArray();

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    long startTime = System.currentTimeMillis();
                    //array is final. copying array
                    sort(in);
                    long finishTime = System.currentTimeMillis();
                    long time = finishTime - startTime;
                    try (Writer writer = new PrintWriter(new BufferedWriter(new FileWriter("../../results.html", true)))) {
                        writer.write("Java : HeapSort-Array:  " + time + "\n");
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
