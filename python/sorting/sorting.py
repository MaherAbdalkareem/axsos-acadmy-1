def sort(arr):
    for x in range(1,len(arr),1):
        for i in range(1,len(arr),1):
            if arr[i]<arr[i-1] :
                arr[i],arr[i-1]=arr[i-1],arr[i]
    return arr

print(sort([1,7,5,3,8,6,2,4,-5]))
