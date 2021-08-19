#Ryan Carey
#polyArithmetic

def standardize(poly):
    poly.reverse()
    if poly[0]==0:
        poly.pop(0)
    poly.reverse()
    return poly[:]

def isZeroPoly(poly):
    poly=standardize(poly)
    if poly==[]:
        return True
    else:
        return False

def addPoly(poly, poly2):
    count=1
    poly=standardize(poly)
    poly2=standardize(poly2)
    poly3=[]
    if len(poly)>len(poly2):
        for i in range(0,len(poly2)):
            poly3.append(poly[i]+poly2[i])
            count=count+1
        poly3.extend(poly[count:])
        poly3=standardize(poly3)
        return poly3
    else:
        for i in range(0,len(poly)):
            poly3.append(poly[i]+poly2[i])
            count=count+1
        poly3.extend(poly2[count:])
        poly3=standardize(poly3)
        return poly3

def scalePoly(num,poly):
    poly=standardize(poly)
    poly2=[]
    for i in range(0,len(poly)):
        poly2.append(num*poly[i])
    poly2=standardize(poly2)
    return poly2

def constCoef(poly):
    poly=standardize(poly)
    return poly[0]

def shiftLeft(poly):
    poly=standardize(poly)
    poly.insert(0,0)
    return poly

def shiftRight(poly):
    poly=standardize(poly)
    return poly[1:]

def mulPoly(poly,poly2):
    poly=standardize(poly)
    poly2=standardize(poly2)
    if shiftRight(poly)==[]:
        return scalePoly(poly[0],poly2)
    return addPoly(mulPoly(shiftRight(poly),shiftLeft(poly2)),scalePoly(poly[0],poly2))

print(mulPoly([1,1],[2,1]))
