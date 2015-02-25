__author__ = 'garylaptop'
__author__ = 'GaryPC'
from timeit import Timer
def insertionSort(alist):
    for index in range(1,len(alist)):

        currentvalue = alist[index]
        position = index

        while position>0 and alist[position-1]>currentvalue:
            alist[position]=alist[position-1]
            position = position-1

        alist[position]=currentvalue

with open('../ranData.txt') as f:
    arr = f.readlines()

if __name__=='__main__':
    t = Timer(lambda: insertionSort(arr))
    with open('../results.html', 'a') as r:
        r.write("Python-insertionSort" + str(t.timeit(number=1)) + '\n')