def bubbleSort(lst):
    x=0
    while x<(len(lst)+1):
        for i in range(0,(len(lst)-1)):
            if lst[i]>lst[i+1]:
                lst[i],lst[i+1] = lst[i+1],lst[i]
            else:
                x = x+1
    return lst

lst=[0,10,31,4,3,87,12]
lst=bubbleSort(lst)
print(lst)

