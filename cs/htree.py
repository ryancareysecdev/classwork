"""
Author: Mike Peterson
Assignment: H-Tree Lab
9/24/10
"""
import turtle #allows the pen tool to be used

def drawH(s): #draws H using the users input length. Starts with pen down and ends with pen up
    turtle.down()
    turtle.fd(s)
    turtle.lt(90)
    turtle.fd(s)
    turtle.bk(s*2)
    turtle.fd(s)
    turtle.lt(90)
    turtle.fd(s*2)
    turtle.rt(90)
    turtle.fd(s)
    turtle.bk(s*2)
    turtle.fd(s)
    turtle.rt(90)
    turtle.fd(s)
    turtle.up()

def recH(n,s): #recursion function, that draws a H at each of the four corners
    if n%2 == 0:# color. If variable is even then it is Blue, else it is Orange
        turtle.color("Blue")
    else:
        turtle.color("Orange")
    if n > 0: #automatically draws the first H if greater than 0.
        drawH(s)
        if n > 1: #If greater than 1, we begin to draw H's at each corner
            turtle.fd(s)
            turtle.lt(90)
            turtle.fd(s)
            turtle.rt(90+45) #Each H is rotated 45 degrees from original angle
            recH(n-1,s/2) #makes the function lose one and size is cut in half for the new recursion
            turtle.lt(90+45)
            turtle.bk(s*2)
            turtle.rt(45)
            recH(n-1,s/2)
            turtle.lt(45)
            turtle.fd(s)
            turtle.lt(90)
            turtle.fd(s*2)
            turtle.lt(90)
            turtle.fd(s)
            turtle.rt(90+45)
            recH(n-1,s/2)
            turtle.lt(90+45)
            turtle.bk(s*2)
            turtle.rt(180+45)
            recH(n-1,s/2)
            turtle.lt(45)
            turtle.bk(s)
            turtle.rt(90)
            turtle.fd(s)

n = int(input("Enter the Number of Recursions: "))
s = int(input("Enter the Size: ")) #The user inputs both the number of recursions and the size
recH(n,s) #Calls the recursive function using the user's inputs.

def test(): #The test function
    turtle.reset() #clears
    input("Hit Enter to Run recH(0, 20)")
    recH(0,20) #shouldn't work. 0 H's should be shown
    turtle.reset()
    input("Hit Enter to Run recH(-45,20)")
    recH(-45,20)#negative number should also not work
    turtle.reset()
    input("Hit Enter to Run recH(1,20)")
    recH(1,20)#Should print 1 H
    turtle.reset()
    input("Hit Enter to Run recH(2,20)")
    recH(2,20)#Should print 1 H and and H on each corner
    turtle.reset()
    input("Hit Enter to Run recH(3,20)")
    recH(3,20)#Should use recursion 3 times
    turtle.reset()


#test()
