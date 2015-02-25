// ArraySorting.cpp : Defines the entry point for the console application. // #include "stdafx.h"
#include <stdio.h> 
#include <stdlib.h> 
#include <time.h> 
#include <iostream> 
#include <fstream> 
using namespace std; 
void shuffle(int *arr, size_t n) { if (n > 1) { size_t i; srand(time(NULL)); for (i = 0; i < n - 1; i++) { size_t j = i + rand() / (RAND_MAX / (n - i) + 1); int t = arr[j]; arr[j] = arr[i]; arr[i] = t; } } } int main() { int i; int arr[1000000]; for (i=0; i<1000000; i++){ arr[i] = i; } shuffle(arr, 1000000); ofstream myfile; myfile.open ("numbers.txt"); for (i=0; i<1000000; i++){ myfile << arr[i] << "\n"; } myfile.close(); return 0; }
