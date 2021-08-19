
class Customer:
    def __init__(self, name, date):
        self.__customer_name = name
        self.__shopping_date = date
        self.__shopping_cart = []

    def checkname(self):
        return self.__customer_name

    def checkdate(self):
        return self.__shopping_date

    def additem(self):
        name = input('What would you like to buy?  ')
        price = float(input('How much is it?  '))
        quantity = float(input('How many would you like?  '))
        newitem = ItemToPurchase(name, price, quantity)
        self.__shopping_cart.append(newitem)

    def removeitem(self, item):
        for i in self.__shopping_cart:
            if i.getname() == item:
                print('Found and removed.')
                self.__shopping_cart.remove(i)
            else:
                pass

    def checkout(self):
        totalcost = 0
        print('Name:', self.__customer_name, '\nShopping Date:', self.__shopping_date)
        print('\nPurchased items:')
        for i in self.__shopping_cart:
            print('Name:', i.getname(), '\nPrice: $%.2f' % i.getprice(), '\nQuantity:', i.getquantity())
            totalcost += i.get_item_cost()
        print('Total cost is: $%.2f' % totalcost)
        

        

class ItemToPurchase:
    def __init__(self, name, price, quantity):
        self.__item_name = name
        self.__item_price = price
        self.__item_quantity = quantity

    def getname(self):
        return self.__item_name

    def getprice(self):
        return self.__item_price

    def getquantity(self):
        return self.__item_quantity
    
    def get_item_cost(self):
        return (self.__item_quantity * self.__item_price)

    
        
def main():
    ryanshop = Customer(input('Name: '), input('Date: '))
    print('A new shopper!')
    itemnumber = int(input('How many items does the customer want add into shopping cart? '))
    for i in range(itemnumber):
        ryanshop.additem()
    removethese = int(input('How many items does the customer want to remove from the shopping cart? '))
    for i in range(removethese):
        ryanshop.removeitem(input('What would you like to remove? '))
    ryanshop.checkout()
    
    

main()
