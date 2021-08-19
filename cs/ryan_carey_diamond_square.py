import turtle
import math

x=10

#initializes
def init(mx):
    turtle.setworldcoordinates(-mx/2, -mx/2, mx/2, mx/2)
    turtle.up()
    turtle.goto(((-mx/2)+(x/2)), ((-mx/2)+(x/2)))
    turtle.left(90)

#generic square
def draw_square():
    turtle.down()
    turtle.forward(x)
    turtle.right(90)
    turtle.forward(x)
    turtle.right(90)
    turtle.forward(x)
    turtle.right(90)
    turtle.forward(x)
    turtle.right(90)

#sets starting point for rotated square, then draws it using draw_square function
def draw_diamond():
    turtle.up()
    turtle.goto(0, (-7))
    turtle.left(45)
    draw_square()

init(2*x)
draw_square()
draw_diamond()
