__author__ = 'garylaptop'
from timeit import Timer
def shellSort(array):
    "Shell sort using Shell's (original) gap sequence: n/2, n/4, ..., 1."
    gap = len(array) // 2
    # loop over the gaps
    while gap > 0:
        # do the insertion sort
        for i in range(gap, len(array)):
            val = array[i]
            j = i
            while j >= gap and array[j - gap] > val:
                array[j] = array[j - gap]
                j -= gap
            array[j] = val
        gap //= 2

with open('randData.txt') as f:
    arr = f.readlines()

if __name__=='__main__':
    t = Timer(lambda: shellSort(arr))
    print (t.timeit(number=1))
