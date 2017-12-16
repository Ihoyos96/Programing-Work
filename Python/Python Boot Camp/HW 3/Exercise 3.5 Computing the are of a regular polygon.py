import math

#setting variable names with inputs
NumberOf_sides = eval(input("Enter the number oof sides: "))
LengthOf_sides = eval(input("Enter the length of the sides: "))

#simplifying variable names for use in equation
n = NumberOf_sides
s = LengthOf_sides

#equation for computing area of a regular polygon
Area = ((n * (s**2))/(4 * (math.tan((math.pi)/n))))

#printing results
print('The area of the polygon is', end=' ')
print(Area)

