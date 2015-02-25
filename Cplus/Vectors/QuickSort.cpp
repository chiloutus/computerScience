
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

int partition(vector<int>& A, int p,int q)
{
    int x= A[p];
    int i=p;
    int j;

    for(j=p+1; j<q; j++)
    {
        if(A[j]<=x)
        {
            i=i+1;
            swap(A[i],A[j]);
        }

    }

    swap(A[i],A[p]);
    return i;
}

void quickSort(vector<int>& A, int p,int q)
{
    int r;
    if(p<q)
    {
        r=partition(A,p,q);
        quickSort(A,p,r);  
        quickSort(A,r+1,q);
    }
}




int main()
{
	ifstream file("../../ranData.txt");
	ofstream outfile;
	string str;
	vector<int> numbers;
	int num;
	while(getline(file, str))
	{
		num = atoi(str.c_str());
		numbers.push_back(num);
	}
	clock_t begin = clock();
	quickSort(numbers, 0, numbers.size());
	clock_t end = clock();
	double elapsed_secs = double(end - begin) / CLOCKS_PER_SEC;

    outfile.open("../../results.html", std::ios_base::app);
    outfile << "C++ QuickSort : Vectors : " << elapsed_secs <<"\n";
	return 0;
}