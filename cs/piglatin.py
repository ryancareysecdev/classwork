def isVowel(currchar):
        if currchar=='a' or currchar=='e' or currchar=='i' or currchar=='o' or currchar=='u':
            return True
        else:
            return False
        
def wordToPigLatin(currstring):
        if currstring=='':
            return
        x=1
        if isVowel(currstring[x-1])==False:
                    x=x+1
        print(currstring[x:]+'-'+currstring[:x]+'ay')
        return currstring[x:]+'-'+currstring[:x]+'ay'

def fileNameToPigLatin(fileName):
        f=open(fileName)
        for line in f:
            wordToPigLatin(line)

fileNameToPigLatin('pigtest.txt')
