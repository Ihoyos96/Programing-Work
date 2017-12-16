
employee_name = input('Name:  ')
weekly_hours = eval(input('Hours worked in a week:  '))
pay_rate = eval(input('Hourly pay rate:  '))
federal_taxR = eval(input('Federal tax withholding rate:  '))
state_taxR = eval(input('State tax withholding rate:  '))

#GROSS PAY#
gross_pay = round(weekly_hours * pay_rate, 2)

#COSMETICS----------------------------
#Federal tax witholdings rate in %   #|
fed_p = round(federal_taxR * 100, 2) #|
#State tax withholdings rate in %    #|
state_p = round(state_taxR * 100, 2) #|
#COSMETICS----------------------------

#Amount deducted by the Federal tax
federal_withholding = round(gross_pay * federal_taxR, 2)

#PAY AFTER FED DEDUCTION#
PAFD = round(gross_pay - federal_withholding, 2)

#Amount deducted by the State tax
state_withholding = round(gross_pay * state_taxR, 2)

#TOTAL DEDUCTIONS
total_deduction = round(federal_withholding + state_withholding, 2)

#NET PAY/////NET#PAY/////NET PAY#
net_pay = round(gross_pay - total_deduction, 2)

print(' ')
print('Please find your Payroll data below:')
print(' ')
print(' ')
print(' ')
print(' ')
print(' ')
print(' ')
print(' ')
print(' ')
print(' ')
print(' ')
print('Employee Name: ', end=' ')
print(employee_name)
print('Hours Worked: ', end=' ')
print(weekly_hours)
print('Pay Rate: ', end=' ')
print('$', end='')
print(pay_rate)
print('Gross Pay: ', end=' ')
print('$', end='')
print(gross_pay)
print('Deductions:')
print('   Federal Withholding', end=' ')
print('(', end='')
print(fed_p, end='')
print('%): ', end=' ')
print('$', end='')
print(federal_withholding)
print('   State Withholding', end=' ')
print('(', end='')
print(state_p, end='')
print('%): ', end=' ')
print('$', end='')
print(state_withholding)
print('   Total Deduction: ', end=' ')
print('$', end='')
print(total_deduction)
print('Net Pay:  ', end=' ')
print('$', end='')
print(net_pay)
