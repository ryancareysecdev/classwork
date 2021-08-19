
class ShoppingCart:
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

    def modifyitem(self, item):
        for i in self.__shopping_cart:
            if i.getname() == item:
                self.__shopping_cart.remove(i)
                print('Found and modified.')
                self.additem()
            else:
                print('Not Found in Cart.')

    def get_num_items(self):
        return len(self.__shopping_cart)

    def printdescriptions(self):
        for i in self.__shopping_cart:
            print(self.getdesc())

    def checkout(self):
        totalcost = 0
        if len(self.__shopping_cart) == 0:
            print('SHOPPING CART IS EMPTY')
            pass
        else:
            print('Name:', self.__customer_name, '\nShopping Date:', self.__shopping_date)
            print('\nPurchased items:')
            for i in self.__shopping_cart:
                print('Name:', i.getname(), '\nPrice: $%.2f' % i.getprice(), '\nQuantity:', i.getquantity())
                totalcost += i.get_item_cost()
            print('Total cost is: $%.2f' % totalcost)
        

        

class ItemToPurchase:
    def __init__(self, name, price, quantity, desc):
        self.__item_name = name
        self.__item_price = price
        self.__item_quantity = quantity
        self.__item_desc = desc

    def getname(self):
        return self.__item_name

    def getdesc(self):
        return self.__item_desc

    def getprice(self):
        return self.__item_price

    def getquantity(self):
        return self.__item_quantity
    
    def get_item_cost(self):
        return (self.__item_quantity * self.__item_price)

def printmenu(self, cart):
    print('MENU')
    print('a - Add item to cart')
    print('r - Remove item from cart')
    print('c - Change item quantity')
    print('i - Output item descriptions')
    print('o - Output shopping cart')
    print('q - Quit\n')

    answer = ''

    while answer != 'q':
        answer = input('Choose an option: ')
        if answer == 'a':
            cart.additem()
        elif answer == 'r':
            cart.removeitem(input('What would you like to remove: '))
        elif answer == 'c':
            cart.modifyitem(input('Which item would you like to change: '))
        elif answer == 'i':
            cart.modifyitem(input('Which item would you like to change: '))
        elif answer == 'o':
            cart.checkout()
        
def main():
    ryanshop = ShoppingCart(input('Name: '), input('Date: '))
    print('A new shopper!')
    itemnumber = int(input('How many items does the customer want add into shopping cart? '))
    for i in range(itemnumber):
        ryanshop.additem()
    removethese = int(input('How many items does the customer want to remove from the shopping cart? '))
    for i in range(removethese):
        ryanshop.removeitem(input('What would you like to remove? '))
    ryanshop.checkout()
    
    

main()
