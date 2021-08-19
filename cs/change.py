#Ryan Carey
#change.py
#greedy algorithm

class CoinObject():
   __slots__ = ('increment','numberOf')


def mkCoinObject(increment, numberOf):
   struct = CoinObject()
   struct.increment = increment
   struct.numberOf = numberOf
   return struct


def make_change(cash, increments):
   increment_list = increments[:]
   increment_list.sort()

   change = []
   
   while cash > 0 and len(increment_list) > 0:
      increment = increment_list.pop()

      coins = cash // increment
      cash = cash - coins * increment

      if coins > 0:
         change.append(mkCoinObject(increment, coins))
   
   if cash > 0:
      return None
   else:
      return change

def readIncrements(prompt, sentinel):
   increments = []
   while True:
      val = int(input(prompt))
      if val == sentinel:
         return increments
      else:
         increments.append(val)


def displayChange(change):
   print("Your change:")
   for entry in change:
      print(entry.numberOf, "coin/s of value", entry.increment, "each.")


increments = readIncrements("Enter incrementination (-1 to end): ", -1)
   
print("Change increments are:", increments)

cash = int(input("Make change for: "))

change = make_change(cash, increments)

if change == None:
    print("Can't make correct change!")
else:
    displayChange(change)
