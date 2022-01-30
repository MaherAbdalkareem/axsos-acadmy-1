def bigger_size(arr):
    for x in range (len(arr)):
        if arr[x]>0:
            arr[x]="big"
    return arr
print(bigger_size([-1,2,5,-5]))


def Count_Positives(arr):
    count=0
    for x in range (len(arr)):
        if arr[x]>0:
            count+=1
    arr[len(arr)-1]=count
    return arr
print(Count_Positives([-1,1,1,1]))


def Sum_Total(arr):
    sum=0
    for x in range(len(arr)):
        sum+=arr[x]
    return sum
print(Sum_Total([1,2,3,4]))


def Average(arr):
    sum=0
    for x in range(len(arr)):
        sum+=arr[x]
    avg=sum/len(arr)
    return avg
print(Average([1,2,3,4]))



def length(arr):
    count=0
    for x in arr:
        count+=1
    return count
print(length([1,2,3,4]))


def Minimum(arr):
    if len(arr)==0:
        return False
    min=arr[0]
    for x in arr:
        if x<min:
            min=x
    return min
print(Minimum([]))


def Maximum(arr):
    if len(arr)==0:
        return False
    max=arr[0]
    for x in arr:
        if x>max:
            max=x
    return max
print(Maximum([]))


def Ultimate_Analysis(arr):
    dec={
        'sumTotal': Sum_Total(arr),
        'average': Average(arr), 
        'minimum': Minimum(arr), 
        'maximum': Maximum(arr), 
        'length': length(arr) }
    return dec
print(Ultimate_Analysis([37,2,1,-9]))


from math import floor
def Reverse_List(arr):
    y=floor(len(arr)/2)
    for x in range (y):
        temp=arr[x]
        arr[x]=arr[len(arr)-1-x]
        arr[len(arr)-1-x]=temp
    return arr
print(Reverse_List([1,2,3,4,5]))

