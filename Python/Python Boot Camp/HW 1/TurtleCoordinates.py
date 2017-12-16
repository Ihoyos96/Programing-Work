import turtle
print('Please enter coordinate with the proper format! Thank you')
point_one = eval(input('Enter the first points coordinate: '))
point_two = eval(input('Enter the second points coordinate: '))

turtle.color("red")
turtle.penup()
turtle.goto(point_one)
turtle.write((point_one))
turtle.pendown()
turtle.goto(point_two)
turtle.write((point_two))
