#Ryan Carey
#rmc5242@g.rit.edu
#htree

from turtle import *
import math

def init(mx): #sets a suitable environment
    setworldcoordinates(-mx/2,-mx/2,mx/2,mx/2)
    up()
    goto(0,0)
    down()
    left(90)

def colorcheck(reps): #changes the color
    if reps % 2 == 0:
        color("Blue")
    else:
        color("Orange")


def recursive_h(reps,length): #draws the h's...recursively
    if reps == 0:
        return
    else:
        colorcheck(reps)
        right(90)
        forward(length/2)
        left(90)
        forward(length/2)
        right(45)
        recursive_h(reps-1,length/2)
        colorcheck(reps)
        left(45)
        back(length)
        right(180)
        left(45)
        recursive_h(reps-1,length/2)
        colorcheck(reps)
        right(45)
        back(length/2)
        right(90)
        forward(length)
        right(90)
        forward(length/2)
        left(45)
        recursive_h(reps-1,length/2)
        colorcheck(reps)
        right(45)
        back(length)
        right(180)
        right(45)
        recursive_h(reps-1,length/2)
        colorcheck(reps)
        left(45)
        back(length/2)
        left(90)
        forward(length/2)
        left(90)            

def test():
    length=10
    reset()
    recursive_h(0,10) #nothing
    reset()
    recursive_h(1,10) #one h
    reset()
    recursive_h(2,10) #2 iterations
    reset()
    recursive_h(5,10) #5 iterations

length=int(input("Enter the size of initial H:")) #gets user input for length
reps=int(input("Enter the number of iterations:")) #gets user input for the number of iterations
init(length*2)
recursive_h(reps,length)
#test()
            
