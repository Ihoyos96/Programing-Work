data = eval(input("Enter numbers divided by a coma: "))

limit = ((len(data))-1)
n = 0
largest_number = 0
global_LN_occurences = 1
    
for i in range(limit):
    if data[n] > largest_number:
        largest_number = data[n]
        global_LN_occurences = 1
        n = n+1
        continue
    elif data[n] < largest_number:
        n = n+1
        continue
    elif data[n] == largest_number:
        global_LN_occurences = (global_LN_occurences + 1)
        n = n+1
        continue



print('The largest number is', end=' ')
print(largest_number, end='')
print('.')
print('The largest number appears', end=' ')
print(global_LN_occurences, end=' ')
print('times in the sequence.')
