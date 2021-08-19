from turtle import *

#initializes the environment
def init(mx):
    setworldcoordinates((-mx/2)-2, (-mx/2)-2, (mx/2)+2, (mx/2)+2)
    up()
    goto(0, 0)
    left(180)
    down()

#draws a simple box
def draw_box(length, divisions):
    forward(length)
    right(90)
    forward(length)
    right(90)
    forward(length)
    right(90)
    forward(length)
    right(90)
    right(90/divisions)

#uses multiple variables and loops to determine how much to turn, when to stop etc.
def draw_moving(count, divisions, rolls):
    if rolls==0:
        return
    if count==divisions:
      up()
      right(90)
      forward(length)
      left(180)
      count=0
      down()
      draw_moving(count, divisions, rolls-1)
    else:
      draw_box(10, divisions)
      draw_moving(count+1, divisions, rolls)


count=0
length=10
divisions=int(input("How many frames?"))
rolls=int(input("How many turns?"))
init(100)
draw_moving(count, divisions, rolls)
