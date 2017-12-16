Savings = eval(input("Enter your monthly savings amount"))

Month_one = ((Savings) * (1 + .00417))
Month_two = ((Month_one + Savings) * (1 + .00417))
Month_three = ((Month_two + Savings) * (1 + .00417))
Month_four = ((Month_three + Savings) * (1 + .00417))
Month_five = ((Month_four + Savings) * (1 + .00417))
Month_six = round(((Month_five + Savings) * (1 + .00417)), 2)

print(Month_six)
