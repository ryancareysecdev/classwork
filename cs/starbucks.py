#Ryan Carey
#rmc5242.rit.edu

def median(lst):
    if len(lst)%2==0:
        return (lst[len(lst)//2]+lst[(len(lst)//2)-1]//2)
    else:
        return lst(len(lst)//2)

def sort(lst):
    x=0
    while x<(len(lst)+1):
        for i in range(0,(len(lst)-1)):
            if lst[i]>lst[i+1]:
                lst[i],lst[i+1] = lst[i+1],lst[i]
            else:
                x = x+1
    return lst


lst=[]
f=open(input('Filename? '))
for line in f:
    numlst = line.split()
    for part in numlst:
        if part.isdigit():
            lst.append(int(part))
lst=sort(lst)
print(median(lst))
