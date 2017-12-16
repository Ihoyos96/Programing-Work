investmentAmount = eval(input('Enter investment amount: '))
interest_rate = eval(input('Enter the interest rate as a whole number: '))


years = 1
months = (years*12)
annualInterest_rate = (interest_rate/100)
monthlyInterest_rate = (annualInterest_rate/12)

futureInvestmentValue = investmentAmount * ((1 + monthlyInterest_rate)**months)

print('Years                 Future Value')
print('Annual interest rate: ', interest_rate, '%')
print(years, '                    ', format(futureInvestmentValue,'.2f'))

for i in range(9):
    months = (years*12)
    annualInterest_rate = (interest_rate/100)
    monthlyInterest_rate = (annualInterest_rate/12)
    futureInvestmentValue = investmentAmount * ((1 + monthlyInterest_rate)**months)
    print(years, '                    ', format(futureInvestmentValue,'.2f'))
    years = years + 1

for i in range(21):
    months = (years*12)
    annualInterest_rate = (interest_rate/100)
    monthlyInterest_rate = (annualInterest_rate/12)
    futureInvestmentValue = investmentAmount * ((1 + monthlyInterest_rate)**months)
    print(years, '                   ', format(futureInvestmentValue,'.2f'))
    years = years + 1
