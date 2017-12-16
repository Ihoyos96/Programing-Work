N = input("Enter any number ad the Genie will reverse it")

R = N[::-1]

print(R)





Celsius = eval(input("Enter the amount of Celsius' to convert to Farenheit ad press enter"))

Farenheit = (9/5)* Celsius + 3

print(Farenheit, end=" ")
print("Degrees Farenheit")







Minutes = eval(input("How many minutes do you want to convert"))

Years = int((Minutes/525600))
Days = int(((Minutes/60)/24)%365)

print(Minutes, end=" ")
print("is approximately", end=" ")
print(Years, end="")
print(" years and approximately", end=" ")
print(Days, end=" ")
print("days")







Savings = eval(input("Enter your monthly savings amount"))

Month_one = ((Savings) * (1 + .00417))
Month_two = ((Month_one + Savings) * (1 + .00417))
Month_three = ((Month_two + Savings) * (1 + .00417))
Month_four = ((Month_three + Savings) * (1 + .00417))
Month_five = ((Month_four + Savings) * (1 + .00417))
Month_six = round(((Month_five + Savings) * (1 + .00417)), 2)

print(Month_six)








import turtle

turtle.penup()
turtle.goto(100,0)
turtle.goto(100,-200)
turtle.goto(-100,-200)
turtle.goto(-100,0)
turtle.goto(100,0)
turtle.pendown()
turtle.circle(100)
turtle.penup()
turtle.goto(100,-200)
turtle.pendown()
turtle.circle(100)
turtle.penup()
turtle.goto(-100,-200)
turtle.pendown()
turtle.circle(100)
turtle.penup()
turtle.goto(-100,0)
turtle.pendown()
turtle.circle(100)
turtle.penup()
turtle.goto(100,0)
turtle.pendown()
turtle.cirlce(100)
