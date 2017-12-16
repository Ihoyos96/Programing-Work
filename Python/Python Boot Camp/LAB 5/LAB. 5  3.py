
kilograms = 1
kilogramsp = (kilograms * 2.2)
pounds = 20
poundsk = (pounds * .45)
print('Kilograms', '  ', 'Pounds','  ', 'Pounds', '      ', 'Kilograms')
print(format(kilograms,'.2f'),'         ', format(kilogramsp,'.2f'), ' | ', end='')
print(format(pounds,'.2f'),'       ', (format(poundsk,'.2f')))

for i in range(99):
    kilograms = (kilograms + 2)
    pounds = (pounds + 5)
    kilogramsp = (kilograms * 2.2)
    poundsk = (pounds * .45)
    print(format(kilograms,'.2f'),'         ', format(kilogramsp,'.2f'), ' | ', end='')
    print(format(pounds,'.2f'),'        ', (format(poundsk,'.2f')))

    
