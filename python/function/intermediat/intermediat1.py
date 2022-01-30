import random

#print(randInt()) 		    # should print a random integer between 0 to 100
def randInt(min=0, max=100):
    num = round(random.random()*100)
    return num
#print(randInt(max=50)) 	    # should print a random integer between 0 to 50
def randInt(min=0, max=100):
    num = round(random.random()*max)
    return num
#print(randInt(min=50)) 	    # should print a random integer between 50 to 100
def randInt(min=0, max=100):
    num =round(random.random()*(100-min)+min)
    return num
#print(randInt(min=50, max=500))    # should print a random integer between 50 and 500
def randInt(min=0, max=100):
    num =round(random.random()*(max-min)+min)
    return num
