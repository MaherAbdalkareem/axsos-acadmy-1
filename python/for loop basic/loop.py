for x in range (0,151,1):
    print(x)

for x in range(5,1001,1):
    if x%5==0 :
        print(x)

for x in range(1,101,1):
    if x%10 ==0:
        print("coding dojo")
    elif x%5==0:
        print("coding")
    else :
        print(x)
sum=0
for x in range(0,500001,1):
    if x%2 !=0 :
        sum+=x
print(sum)
for x in range(2018,0,-4):
    print(x)
lownum=4
highnum=50
mult=3
for x in range(lownum,highnum+1,1):
    if(x%mult==0):
        print(x)