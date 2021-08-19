import random, time
def mergeSort(alist):
    if len(alist)>1:
        mid = len(alist)//2
        lefthalf = alist[:mid]
        righthalf = alist[mid:]

        mergeSort(lefthalf)
        mergeSort(righthalf)

        i=0
        j=0
        k=0
        while i < len(lefthalf) and j < len(righthalf):
            if lefthalf[i] < righthalf[j]:
                alist[k]=lefthalf[i]
                i=i+1
            else:
                alist[k]=righthalf[j]
                j=j+1
            k=k+1

        while i < len(lefthalf):
            alist[k]=lefthalf[i]
            i=i+1
            k=k+1

        while j < len(righthalf):
            alist[k]=righthalf[j]
            j=j+1
            k=k+1

def bubbleSort(alist):
    for passnum in range(len(alist)-1,0,-1):
        for i in range(passnum):
            if alist[i]>alist[i+1]:
                temp = alist[i]
                alist[i] = alist[i+1]
                alist[i+1] = temp
alist = []
numofnums = 0
while (numofnums != -1):
    log = open('SortLog.txt', 'a+')
    numofnums = int(input('How many numbers in the list (enter -1 to end): '))
    for i in range(0, numofnums):
        alist.append(random.randint(1,10000))
    blist = alist
    starttime1 = time.time()
    bubbleSort(alist)
    bubbletime = time.time() - starttime1

    starttime2 = time.time()
    mergeSort(blist)
    mergetime = time.time() - starttime2

    writethis = str(numofnums) + ' Bubbletime: ' + str(bubbletime) + ' Mergetime: ' + str(mergetime) + '\n'
    if (numofnums != -1):
        log.write(writethis)
    log.close()
exit()
