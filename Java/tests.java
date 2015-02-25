public class GenerateArray {
    public static void main(String[] args){
        String unsorted = "";
        int[] array = new int[1000];
        for(int i=0;i<1000;i++)
        {
            int random = (int)(Math.random()*1000);
            for(int j=0;j<1000;j++)
            {
                if(random == array[j])
                {
                    random = (int)(Math.random()*1000);
                    j=0;
                }
            }
            array[i]=random;
        }

        for(int i=0;i<1000;i++)
        {
            unsorted += array[i] + "\n";
        }
        try {
            PrintWriter out = new PrintWriter("numbers.txt");
            out.println(unsorted);
            out.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
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
        final int in[] = makeArray.mArray();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                //array is final. copying array
                sort(in);
                long finishTime = System.currentTimeMillis();
                long time = finishTime-startTime;
                for(int i = 0; i < in.length; i++)
                {
                    System.out.println(in[i]);
                }
                System.out.println("Time HeapSort took in milliseconds :" + time);
            }
        });


        t.start();

    }

}

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
    public static void main(String[] args)
    {
        final int in[] = makeArray.mArray();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                //array is final. copying array
                insert(in);
                long finishTime = System.currentTimeMillis();
                long time = finishTime-startTime;
                for(int z = 0; z < in.length; z++)
                {
                    System.out.println(in[z]);
                }
                System.out.println("Time Insertion Sort took in milliseconds :" + time);
            }
        });


        t.start();

    }

}
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
        final int in[] = makeArray.mArray();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                //array is final. copying array
                quickSort(in,0,in.length -1);
                long finishTime = System.currentTimeMillis();
                long time = finishTime-startTime;
                for(int i = 0; i < in.length; i++)
                {
                    System.out.println(in[i]);
                }
                System.out.println("Time HeapSort took in milliseconds :" + time);
            }
        });


        t.start();

    }

}