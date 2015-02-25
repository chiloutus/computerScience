#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

void InsertionSort( vector <int> &num)
{
     int i, j, key, numLength = num.size( );
     for(j = 1; j < numLength; j++)    // Start with 1 (not 0)
    {
           key = num[j];
           for(i = j - 1; (i >= 0) && (num[i] < key); i--)   // Smaller values move up
          {
                 num[i+1] = num[i];
          }
         num[i+1] = key;    //Put key into its proper location
     }
     return;
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
	InsertionSort(numbers);
	clock_t end = clock();
	double elapsed_secs = double(end - begin) / CLOCKS_PER_SEC;

    outfile.open("../../results.html", std::ios_base::app);
    outfile << "C++ InsertionSort : Vectors : " << elapsed_secs << "\n";


	return 0;
}

