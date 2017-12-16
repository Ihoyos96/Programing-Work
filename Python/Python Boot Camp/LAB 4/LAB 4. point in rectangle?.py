

x1, y1 = eval(input('Enter a point with two coordinates: '))

x1f = round(x1, 2)
y1f = round(y1, 2)


if x1>-5 and x1<5 and y1>-2.5 and y1<2.5:
    print('Point ', end='')
    print('(', end='')
    print(x1f,',', y1f, end='')
    print(')', end=' ')
    print('is in the rectangle')
else:
    print('Point ', end='')
    print('(', end='')
    print(x1f,',', y1f, end='')
    print(')', end=' ')
    print('is not in the rectangle')

