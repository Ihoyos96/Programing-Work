import turtle

x1, y1 = eval(input('Enter the center coordinate for circle one: '))
radius1 = eval(input('Enter the radius of circle one: '))
x2, y2 = eval(input('Enter the center coordinate for circle two: '))
radius2 = eval(input('Enter the radius of circle two: '))

#first circle data


edge1 = (y1 - radius1)


turtle.penup()
turtle.goto(x1, y1)
turtle.goto(x1 ,edge1)
turtle.pendown()
turtle.circle(radius1)
turtle.penup()
turtle.goto(x1, y1)

#seconds circle data


edge2 = (y2 - radius2)


turtle.penup()
turtle.goto(x2, y2)
turtle.goto(x2 ,edge2)
turtle.pendown()
turtle.circle(radius2)
turtle.penup()
turtle.goto(x2, y2)


center_distance = ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) ** 0.5

if center_distance <= abs(radius1 - radius2):
    turtle.write('circle two is inside circle one!')

elif center_distance <= abs(radius1 + radius2):
    turtle.write('circle two overlaps circle one!')

print('The distance between both centers is', end=' ')
print(center_distance)
