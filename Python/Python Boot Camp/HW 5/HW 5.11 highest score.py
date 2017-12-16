data = eval(input("Enter the number of students: "))
data2 = eval(input("Enter the students score in increasing or decreasing order: "))

limit = ((len(data2)))
n = 0
largest_number = 0
secondLargest_number = 0

for i in range(limit):
    if data2[n] > largest_number:
        largest_number = data2[n]
    if data2[n] < largest_number and data2[n] > secondLargest_number:
        secondLargest_number = data2[n]
    if data2[n-1] < largest_number and data2[n-1] > secondLargest_number:
        secondLargest_number = data2[n-1]
        n = n+1
        continue
    elif data2[n] == largest_number:
        n = n+1
    elif data2[n] < largest_number and data2[n] <= secondLargest_number:
        n = n+1
        continue



print('The largest score is', end=' ')
print(largest_number, end='')
print('.')
print('The second largest score is', end=' ')
print(secondLargest_number, end='')
print('.')
