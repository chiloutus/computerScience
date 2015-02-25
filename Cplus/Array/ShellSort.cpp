#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

void ShellSort( int (&num)[1000])
{
     int i, temp, flag = 1, numLength = 1000;
     int d = numLength;
     while( flag || (d > 1))      // boolean flag (true when not equal to 0)
     {
          flag = 0;           // reset flag to 0 to check for future swaps
          d = (d+1) / 2;
          for (i = 0; i < (numLength - d); i++)
        {
               if (num[i + d] > num[i])
              {
                      temp = num[i + d];      // swap positions i+d and i
                      num[i + d] = num[i];
                      num[i] = temp;
                      flag = 1;                  // tells swap has occurred
              }
         }
     }
     return;
}

int main()
{
	ifstream file("../../ranData.txt");
	ofstream outfile;
	string str;
	int numbers[1000];
	int num;
	int i =0;
	while(getline(file, str))
	{
		num = atoi(str.c_str());
		numbers[i] = num;
		i++;
	}
	clock_t begin = clock();
	ShellSort(numbers);
	clock_t end = clock();
	double elapsed_secs = double(end - begin) / CLOCKS_PER_SEC;

	for(int i = 0; i < 1000; i++)
	{
		cout << numbers[i] << endl;
	}
    outfile.open("../../results.html", std::ios_base::app);
    outfile << "C++ ShellSort : Arrays : " << elapsed_secs <<"\n";

	return 0;
}
