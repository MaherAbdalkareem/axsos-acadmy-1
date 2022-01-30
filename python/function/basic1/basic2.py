empty=[]
def countdown(num):
    for x in range(num,-1,-1):
        empty.append(x)
    return empty
print(countdown(5))



def print_and_return(value1,value2):
    print(value1)
    return value2
print_and_return(2,1)


def first_plus_length(arr):
    x=arr[0]+len(arr)
    print(x)
y=first_plus_length([5,2,3])



def value_grater(y):
    z=[]
    if len(y)<2:
        return False
    else:
        for x in range(0,len(y),1):
            if y[x]>y[1]:
                z.append(y[x])
        print(len(z))
        return z
print(value_grater([5,4,8,7,9]))



def length_and_value(size,value):
    x=[]
    for N in range(0,size,1):
        x.append(value)
    return x
print(length_and_value(4,2))
