#Ryan Carey
#rmc5242@rit.edu
    

def k_select(lst, k):
    count=0
    smallerLst=[]
    largerLst=[]
    if lst != []:
        pivot = lst[len(lst)//2]
        for num in lst:
            if int(num) < int(pivot):
                smallerLst.append(num)
        for num in lst:
            if int(num) > int(pivot):
                largerLst.append(num)
        for num in lst:
            if num == pivot:
                count = count+1
        
        m = len(smallerLst)
        
        if k>=m and k < (m + count):
            print('Bye')
            return pivot
        elif m > k:
            k_select(smallerLst, k)
            print('Hi')
        else:
            k_select(largerLst, k-m-count)
            print('n00b')
    

f = open(input('Filename? '), 'r')
lst=[]
for line in f:
    numlst = line.split()
    for part in numlst:
        if part.isdigit():
            lst.append(int(part))
median = k_select(lst, int(len(lst)//2))
print(median)
