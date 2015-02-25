
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;
void Swap(std::vector<int>& vHeap, std::vector<int>::size_type i, std::vector<int>::size_type j)
{
	if(i == j)
	return;
 
	int temp;
	temp = vHeap[i];
	vHeap[i] = vHeap[j];
	vHeap[j] = temp;
}
 
void Sift(std::vector<int>& vHeap, const std::vector<int>::size_type heapSize, const std::vector<int>::size_type siftNode)
{
	std::vector<int>::size_type i, j;
 
	j = siftNode;
	do
	{
		i = j;
		if(((2*i + 1) < heapSize) && vHeap[j] < vHeap[2*i + 1])
			j = 2*i + 1;
		if(((2*i + 2) < heapSize) && vHeap[j] < vHeap[2*i + 2])
			j = 2*i + 2;
 
		Swap(vHeap, i, j);
	}
	while(i != j);
}
 
void MakeInitialHeap(std::vector<int>& vHeap)
{
	for(int i = vHeap.size() - 1; i >= 0; --i)
	{
		Sift(vHeap, vHeap.size(), i);
	}
}
 
void HeapSort(std::vector<int>& vHeap)
{
	MakeInitialHeap(vHeap);
	for(std::vector<int>::size_type i = vHeap.size()-1; i > 0; --i)
	{
		Swap(vHeap, i, 0);
		Sift(vHeap, i, 0);
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
	HeapSort(numbers);
	clock_t end = clock();
	double elapsed_secs = double(end - begin) / CLOCKS_PER_SEC;
	

    outfile.open("../../results.html", std::ios_base::app);
    outfile << "C++ heapSort : Vectors : " << elapsed_secs << "\n";
	return 0;
}
