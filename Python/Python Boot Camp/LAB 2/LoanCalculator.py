Inv_amount = eval(input("Enter Your investment amount on this line."))
Ann_intRate = eval(input("Enter Your annual interest rate on this line."))
Mon_intRate = (Ann_intRate*0.01)/12
Num_years = eval(input("Enter the amount of years on which the loan is calculated on this line."))
Fiv = (Inv_amount * ((1 + Mon_intRate)**(Num_years*12)))
result = round(Fiv, 2)
print (result)

