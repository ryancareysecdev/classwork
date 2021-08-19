checkEnthusiasm = 1
def getsale():
    Num = float(input('Enter a sale amount: '))
    while Num < 0:
        Num = float(input('A valid sale please: '))
    return Num

def showResult(Num, commission):
    print('Commission on $%1.2f' % Num, ' is $%1.2f' % commission, sep='')

def CalculateCommission(Num):
    result = (Num * 1.05) - Num
    return result

def main():
    Num = getsale()
    commission = CalculateCommission(Num)
    showResult(Num, commission)
while checkEnthusiasm == 1:
    main()
    checkEnthusiasm = int(input('Enter 1 to continue, 0 to end: '))
