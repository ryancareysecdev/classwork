#Ryan Carey
#Search.py
def searchChar(charToSearchFor, searchString):#compares char to current index of searchString
    for i in range(0, len(searchString)):
        if searchString[i]==charToSearchFor:
            return True


def searchString(stringToSearchFor, searchString):#uses iteration to find stringToSearchFor
    for i in range(0, len(searchString)):
        if stringToSearchFor==searchString[i:len(stringToSearchFor)+i]:
            return True
    return False

def matchPat(patToMatch, searchString):
    i=0
    j=0
    charlist=str.replace(patToMatch, '*', '')
    print(charlist)
    while i<len(searchString):
        if patToMatch[i]!='*':
            if searchChar(charlist[j], searchString)==True:
                j=j+1
        i=i+1
    return False



def searchPat(patToSearchFor, searchString):
    return



print(matchPat('a*c', 'abc'))
print(searchString('ab', 'abc')
print(searchString('bc', 'abc')
print(searchChar('a', 'abc'))
print(searchChar('c', 'abc'))

