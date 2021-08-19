Ryan Carey
Hello World
#import statements
import turtle
import math

#variables
y=2
x=(y/2)

#initializing function
def init(mx):
    turtle.setworldcoordinates(-mx/2, -mx/2, mx/2, mx/2)
    turtle.up()
    turtle.goto((-mx/2), 0)
    turtle.left(90)

#a shift function to move the starting position over one letter width, plus space
def draw_shift():
    turtle.up()
    turtle.right(90)
    turtle.forward(x+(x/2))
    turtle.left(90)

#Original letter, uses back and forth motions to reduce the amount of turns
def draw_h():
    turtle.down()
    turtle.forward(y)
    turtle.backward(x)
    turtle.right(90)
    turtle.forward(x)
    turtle.left(90)
    turtle.forward(x)
    turtle.backward(y)
    turtle.up
    turtle.forward(x)
    turtle.left(90)
    turtle.forward(x)
    turtle.right(90)
    turtle.backward(x)

#uses backward as a backtracking tool
def draw_e():
    turtle.down()
    turtle.forward(y)
    turtle.right(90)
    turtle.forward(x)
    turtle.backward(x)
    turtle.right(90)
    turtle.forward(x)
    turtle.left(90)
    turtle.forward(x)
    turtle.backward(x)
    turtle.right(90)
    turtle.forward(x)
    turtle.left(90)
    turtle.forward(x)
    turtle.backward(x)
    turtle.left(90)

#drawn with 2 lines
def draw_l():
    turtle.down()
    turtle.forward(y)
    turtle.backward(y)
    turtle.right(90)
    turtle.forward(x)
    turtle.backward(x)
    turtle.left(90)
    return

#drawn in the same way as a rectangle
def draw_o():
    turtle.down()
    turtle.forward(y)
    turtle.right(90)
    turtle.forward(x)
    turtle.right(90)
    turtle.forward(y)
    turtle.right(90)
    turtle.forward(x)
    turtle.right(90)

#pythagorean theorem to determine length
def draw_w():
    turtle.down()
    turtle.forward(y)
    turtle.back(y)
    turtle.right(45)
    w=math.sqrt((math.pow(x, 2))/2)
    turtle.forward(w)
    turtle.right(90)
    turtle.forward(w)
    turtle.left(135)
    turtle.forward(y)
    turtle.up()
    turtle.backward(y)
    turtle.left(90)
    turtle.forward(x)
    turtle.right(90)

#simple pythagorean theorem to determine the proper length for the leg of the r
def draw_r():
    turtle.down()
    turtle.forward(y)
    turtle.right(90)
    turtle.forward(x)
    turtle.right(90)
    turtle.forward(x)
    turtle.right(90)
    turtle.forward(x)
    turtle.left(135)
    r=(2*(math.pow(x, 2)))
    turtle.forward(math.sqrt(r))
    turtle.backward(math.sqrt(r))
    turtle.left(135)
    turtle.backward(x)
    
#uses arctangent to determine the correct angle for the D
def draw_d():
    turtle.down()
    turtle.forward(y)
    turtle.right(90)
    turtle.forward(x/2)
    d=(math.sqrt(((x/2)*(x/2))+((y/2)*(y/2))))
    dangle=90-math.degrees(math.atan((x/2)/(y/2)))
    turtle.right(dangle)
    turtle.forward(d)
    turtle.right(180-(2*dangle))
    turtle.forward(d)
    turtle.right(dangle)
    turtle.forward(x/2)
    turtle.right(90)

#hello world

init(y*10)
draw_h()
draw_shift()
draw_e()
draw_shift()
draw_l()
draw_shift()
draw_l()
draw_shift()
draw_o()
draw_shift()
draw_shift()
draw_w()
draw_shift()
draw_o()
draw_shift()
draw_r()
draw_shift()
draw_l()
draw_shift()
draw_d()
input()
turtle.clearscreen()

#test case one: the word low
init(y*10)
draw_l()
draw_shift()
draw_o()
draw_shift()
draw_w()
input()
turtle.clearscreen()

#test case two: the word roll
init(y*10)
draw_r()
draw_shift()
draw_o()
draw_shift()
draw_l()
draw_shift()
draw_l()
input()
turtle.clearscreen()
