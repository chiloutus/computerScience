__author__ = 'garylaptop'
__author__ = 'GaryPC'
from timeit import Timer
def swap(i, j):
    arr[i], arr[j] = arr[j], arr[i]

def heapify(end,i):
    l=2 * i + 1
    r=2 * (i + 1)
    max=i
    if l < end and arr[i] < arr[l]:
        max = l
    if r < end and arr[max] < arr[r]:
        max = r
    if max != i:
        swap(i, max)
        heapify(end, max)

def heap_sort():
    end = len(arr)
    start = end / 2 - 1
    for i in range(start, -1, -1):
        heapify(end, i)
    for i in range(end-1, 0, -1):
        swap(i, 0)
        heapify(i, 0)
with open('../ranData.txt') as f:
    arr = f.readlines()

if __name__=='__main__':
    t = Timer(lambda: heap_sort())
    with open('../results.html', 'a') as r:
        r.write("Python-heapSort" + str(t.timeit(number=1)) + '\n')
