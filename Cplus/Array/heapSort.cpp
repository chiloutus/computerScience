
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;
void siftDown( int *a, int k, int N); 

void swap(int *m, int *n)
{
	int tmp;
	tmp = *m;
	*m = *n;
	*n = tmp;
}

void heapsort( int a[], int N){       
	/* heapify */    
	for (int k = N/2; k >= 0; k--) { 
		siftDown( a, k, N);    
	}     

	while (N-1 > 0) {  
		/* swap the root(maximum value) of the heap 
		with the last element of the heap */
		swap(a[N-1], a[0]); 
		/* put the heap back in max-heap order */
		siftDown(a, 0, N-1);  
		/* N-- : decrease the size of the heap by one 
		so that the previous max value will
        	stay in its proper placement */
		N--;
	}
}  

void siftDown( int *a, int k, int N){     
	while ( k*2 + 1 < N ) { 
		/* For zero-based arrays, the children are 2*i+1 and 2*i+2 */
 		int child = 2*k + 1;    

		/* get bigger child if there are two children */
		if ((child + 1 < N) && (a[child] < a[child+1])) child++;        
       
		if (a[k] < a[child]) {   /* out of max-heap order */        
			swap( a[child], a[k] );  
			/* repeat to continue sifting down the child now */          
			k = child;  
		}        
		else            
			return;    
	}
}
 
int main()
{
	ifstream file("../../randData.txt");
	ofstream outfile;
	string str;
	int numbers[1000];
	int num;
	int i =1;
	while(getline(file, str))
	{
		num = atoi(str.c_str());
		numbers[i] = num;
		i++;
	}
	clock_t begin = clock();
	heapsort(numbers,1000);
	clock_t end = clock();
	double elapsed_secs = double(end - begin) / CLOCKS_PER_SEC;



    outfile.open("../../results.html", std::ios_base::app);
    outfile << "C++ heapSort : Arrays : " << elapsed_secs <<"\n";
	
	return 0;
}
