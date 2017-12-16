import sys
from sys import exit

month_input = input("please enter a month: ").split(' ')
year_input = eval(input("please enter a year: "))

print(month_input[0],end=', ')

#Setting variable for year and value below.
year = year_input
leap_year = 0

#Determines whether the year is a regular or leap year.
if year%100 and year%4 and year%400 == 0:
    leap_year = 1


if leap_year == 1 and month_input == 'February':
    February = 29
    print(year, end=' ')
    print('has ', end='')
    print(February)
    exit(0)
    


print(year, end=' ')
print('has ', end='')



#Setting additional variable for next set of statements.
January = 31
February = 28
leap_February = 29
March = 31
April = 30
May = 31
June = 30
July = 31
August = 31
September = 31
October = 31
November = 30
December = 31

#Turning month input into days value.

if month_input[0] == 'January':
	month = January
	print(month, end='')

if month_input[0] == 'February':
	month = February
	print(month, end='')

if month_input[0] == 'March':
	month = March
	print(month, end='')

if month_input[0] == 'April':
	month = April
	print(month, end='')

if month_input[0] == 'May':
	month = May
	print(month, end='')

if month_input[0] == 'June':
	month = June
	print(month, end='')

if month_input[0] == 'July':
	month = July
	print(month, end='')

if month_input[0] == 'August':
	month = August
	print(month, end='')

if month_input[0] == 'September':
	month = September
	print(month, end='')

if month_input[0] == 'October':
	month = October
	print(month, end='')

if month_input[0] == 'November':
	month = November
	print(month, end='')

if month_input[0] == 'December':
	month = December
	print(month, end='')





print(' days.')

