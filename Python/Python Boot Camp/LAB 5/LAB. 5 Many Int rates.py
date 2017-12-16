#f for floating number
#g for decimal

loan_amount = eval(input('Enter the Loan amount: '))

years = eval(input('Enter the number of years: '))

############Interest Rate for Calculation################
#
#Input Interest rate to be called for astetics#
input_interest_rate  = eval(input('Enter the interest rate: '))
#Actual interest rates for calculations
annualInterest_rate = (input_interest_rate/100)
monthlyInterest_rate = (annualInterest_rate/12)

###Months in loan term###
global_months = (years * 12)

#Monthly payment formulation
monthly_payment = ((loan_amount*monthlyInterest_rate)/(1 - 1/(1 + monthlyInterest_rate)**(global_months)))

###Total Payment For Loan Payoff###
total_payment = (monthly_payment*global_months)

print('Interest Rate    Monthly Payment   Total Payment')
#FIRST PRINT FOR 5%##
print("{:.3%}".format(annualInterest_rate), '         ', format(monthly_payment,'.2f'), '          ', format(total_payment,'.2f'))

for i in range (24):
    input_interest_rate = (input_interest_rate +.125)
    annualInterest_rate = (input_interest_rate/100)
    monthlyInterest_rate = (annualInterest_rate/12)
    global_months = (years * 12)
    monthly_payment = ((loan_amount*monthlyInterest_rate)/(1 - 1/(1 + monthlyInterest_rate)**(global_months)))
    total_payment = (monthly_payment*global_months)
    print("{:.3%}".format(annualInterest_rate), '         ', format(monthly_payment,'.2f'), '          ', format(total_payment,'.2f'))
    
 

    
