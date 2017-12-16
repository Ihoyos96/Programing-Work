print("Solving 2 x 2 linear equations, using formula X = ((ed-bf)/(ad-bc))" +
      " and Y = ((af-ec)/(ad-bc))")
print("Please fill in the following variables with numerical values, to solve the equation.")

a, b, c, d, e, f = eval(input("Plase enter values for a, b, c, d, e, f" +
                                " in the same order, a single line, and divided by comas. Thank you."))
            
#a = eval(input("a = "))
#b = eval(input("b = "))
#c = eval(input("c = "))
#d = eval(input("d = "))
#e = eval(input("e = "))
#f = eval(input("f = "))

X = ((e*d-b*f)/(a*d-b*c))
Y = ((a*f-e*c)/(a*d-b*c))

if((a*d)-(b*c)==0):
    print("The equation has no soltion.")

print("By pluggin in your values we compute that X = ", end='')
print(X, end='')
print(" and Y = ", end='')
print(Y, end='')
print(".")
