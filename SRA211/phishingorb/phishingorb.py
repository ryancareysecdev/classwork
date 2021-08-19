#authors: Ryan Carey and Ryan Hough using open source computer vision, stackexchange, docs and APIs
import numpy as np
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from pathlib import Path
import cv2
from datetime import datetime, timedelta
import platform
import os
import sys
import csv
import time
import glob
from matplotlib import pyplot as graphme
import base64
import copyreg

def comparewithsaved(suspecturl, suspectarray):
	suspectkeypoints, suspectdescriptors = detectfeatures(suspectarray)
	for filename in glob.glob(os.path.join(numpyproperpath, '*.npz')): #traverse the savedarrays folder and load all the numpy arrays
		trustednumpy = np.load(filename) #load references to the data in filename into variables
		trustedimage = trustednumpy['trustedimage']
		trustedkeypoints = trustednumpy['keypoints']
		trusteddescriptors = trustednumpy['descriptors']
		matchedDescriptors = brute.match(suspectdescriptors, trusteddescriptors)
		matchedDescriptors = sorted(matchedDescriptors, key = lambda x:x.distance) #sort by minimum distance
		cumdist = 0
		trustedurl = os.path.basename(filename)
		trustedurl = trustedurl[:-4]
		trustedurl = trustedurl.encode('UTF-8')
		trustedurl = base64.urlsafe_b64decode(trustedurl)
		trustedurl = trustedurl.decode('UTF-8')
		for match in matchedDescriptors[:10]:
			cumdist += match.distance
		if (cumdist < 100 and cumdist != 0): #check validity of the match
			response = 'This url is likely a fishing site. It has features in common with ' + trustedurl
			matchdisplay = cv2.drawMatches(suspectarray, suspectkeypoints, trustedimage, trustedkeypoints, matchedDescriptors[:10], None, flags=2)
			graphme.title('Visual representation of the matched features')
			graphme.imshow(matchdisplay,None,None,'equal'),graphme.show()
			return response
		elif (cumdist == 0 and trustedurl == suspecturl):
			response = 'This url is a legitimate site we have saved information for.'
			matchdisplay = cv2.drawMatches(suspectarray, suspectkeypoints, trustedimage, trustedkeypoints, matchedDescriptors[:10], None, flags=2)
			graphme.title('Visual representation of the matched features')
			graphme.imshow(matchdisplay,None,None,'equal'),graphme.show()
			return response
		elif cumdist > 100:
			response = 'This url is not similar to any of our saved sites, and is not in the phishing csv.'
		trustednumpy.close()
	return response

def buildstoredimageswithfeatures():
	with open(os.path.join(currpath, 'top500.csv'), 'r') as trusted: #open and read urls from the trusted top500 sites.
		readtrusted = csv.reader(trusted)
		rfields = readtrusted.__next__()
		trustedurlField = rfields.index('URL')
		for row in readtrusted:
			trustedurl = row[trustedurlField]
			trustedurl = prependurl(trustedurl)
			getpagescreenshot(trustedurl, 'trustedurl.png')
			while not os.path.isfile('trustedurl.png'):
				time.sleep(1)
			trustedimage = cv2.imread('trustedurl.png', cv2.IMREAD_GRAYSCALE)
			trustedimage = resizer(trustedimage) #now it's been resized
			keypoints, descriptors = detectfeatures(trustedimage)
			trustedurl = trustedurl.encode('UTF-8')
			trustedurlstorage = base64.urlsafe_b64encode(trustedurl) #change trustedurl into a form that can be used as a filename while keeping the url intact for decoding later
			trustedurlstorage = trustedurlstorage.decode('UTF-8')#decode trustedurl so we don't get a type error related to the bytes type
			copyreg.pickle(cv2.KeyPoint().__class__, _pickle_keypoints)
			np.savez(os.path.join(numpypath, trustedurlstorage), trustedimage=trustedimage, keypoints=keypoints, descriptors=descriptors)
			if os.path.isfile('trustedurl.png'):
				os.remove('trustedurl.png')
			
	input('finally done...\n')

def _pickle_keypoints(point):#workaround to allow saving keypoints which normally throw an error when trying to write them to a .npz
    return cv2.KeyPoint, (*point.pt, point.size, point.angle,
                          point.response, point.octave, point.class_id)
def prependurl(url):
	url = 'http://'+url
	return url

def resizer(nump):
	scale_percent = 50 #see above in buildstoredimageswithfeatures
	width = int(nump.shape[1] * scale_percent / 100)
	height = int(nump.shape[0] * scale_percent / 100)
	dim = (width, height)
	nump = cv2.resize(nump, dim, interpolation = cv2.INTER_AREA) #resized
	return nump

def detectfeatures(nump):
	keyp, desc = orb.detectAndCompute(nump,None)
	return keyp, desc

def getpagescreenshot(url, imagename):
	driver.get(url) #go to the given url
	driver.save_screenshot(imagename)
	
def phishingcsv():
	if os.path.isfile('verified_online.csv'):
		if datetime.fromtimestamp(os.path.getmtime("verified_online.csv")) < one_hour_ago:
			os.remove('verified_online.csv')
			driver.get('http://data.phishtank.com/data/6b865298ce2d0dd22ca4be46fd06c61314cca790d8d4de36ff0a7a4a6ebbf9f6/online-valid.csv')
	else:
		driver.get('http://data.phishtank.com/data/6b865298ce2d0dd22ca4be46fd06c61314cca790d8d4de36ff0a7a4a6ebbf9f6/online-valid.csv')
	while not os.path.isfile('verified_online.csv'):
		time.sleep(1)
	else:
		with open(os.path.join(currpath, 'verified_online.csv'), 'r') as knownphishes:
			readphishes = csv.reader(knownphishes)
			pfields = readphishes.__next__()
			urlField = pfields.index('url')
			for row in readphishes:
				if prependurl(row[urlField]) == suspecturl:
					input('This is a fishing site according to the database.Type enter to exit.')
					exit()

orb = cv2.ORB_create()
brute = cv2.BFMatcher_create(cv2.NORM_HAMMING, crossCheck=True)
currpath = os.path.abspath(os.path.curdir)
numpypath = os.path.abspath(os.path.join(currpath, 'savedarrays'))
numpyproperpath = Path(numpypath)
precompute = input('Would you like to go through the top sites and rebuild the comparison data for them? Type y for yes. All other answers mean no: ')

options = webdriver.ChromeOptions()
options.add_argument('--ignore-certificate-errors')
options.add_argument("--test-type")
downloadpref = {"download.default_directory": currpath,
               "directory_upgrade": True,
			   "download.prompt_for_download": False,
               "safebrowsing.enabled": False }
options.add_experimental_option("prefs", downloadpref)
driver = webdriver.Chrome(executable_path=ChromeDriverManager().install(), options=options)


if (precompute == 'y') or (precompute == 'Y'):
	buildstoredimageswithfeatures()
suspecturl = input('Enter or copy/paste a URL: ')
one_hour_ago = datetime.now() - timedelta(hours=1)
if not suspecturl[0:4] == 'http':
	suspecturl = prependurl(suspecturl)
try:
	getpagescreenshot(suspecturl, 'suspecturl.png')
except:
	suspecturl = input('Try a different url, that one did not work: ')
phishingcsv()

suspectimage = cv2.imread('suspecturl.png', cv2.IMREAD_GRAYSCALE)
suspectimage = resizer(suspectimage) #resized

print(comparewithsaved(suspecturl, suspectimage))
driver.close()