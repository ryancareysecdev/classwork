import numpy
import matplotlib
from matplotlib import pyplot
import cv2

im1 = cv2.imread('screen1.png',0)
im2 = cv2.imread('screen2.png',0)
im3 = cv2.imread('screen3.png',0)

orb = cv2.ORB_create()
brute = cv2.BFMatcher_create()

im1kp, im1d = orb.detectAndCompute(im1,None)
im2kp, im2d = orb.detectAndCompute(im2,None)
im3kp, im3d = orb.detectAndCompute(im3,None)

match1and2 = brute.match(im1d,im2d)
match1and2 = sorted(match1and2, key = lambda x:x.distance)
match1and3 = brute.match(im1d,im3d)
match1and3 = sorted(match1and3, key = lambda x:x.distance)


match1and2display = cv2.drawMatches(im1,im1kp,im2,im2kp,match1and2[:7],None,flags=2)
match1and3display = cv2.drawMatches(im1,im1kp,im3,im3kp,match1and3[:7],None,flags=2)

matplotlib.pyplot.imshow(match1and2display)
matplotlib.pyplot.show()

matplotlib.pyplot.imshow(match1and3display)
matplotlib.pyplot.show()
