year = eval(input('Enter a year: '))

while year>1912:
    year = (year - 12)

while year<1900:
    year = (year + 12)

    
#####################
###ZODIAC#DATABASE###
#####################

if year == 1900:
    print('Rat')
if year == 1901:
    print('Ox')
if year == 1902:
    print('Tiger')
if year == 1903:
    print('Rabbit')
if year == 1904:
    print('Dragon')
if year == 1905:
    print('Snake')
if year == 1906:
    print('Horse')
if year == 1907:
    print('Goat')
if year == 1908:
    print('Monkey')
if year == 1909:
    print('Rooster')
if year == 1910:
    print('Dog')
if year == 1911:
    print('Pig')
if year == 1912:
    print('Rat')


