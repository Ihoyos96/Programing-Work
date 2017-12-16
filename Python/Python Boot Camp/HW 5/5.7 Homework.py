import math
n=0

print('Degrees','      ', 'Sin', '          ', 'Cos',)

for i in range (37):
    yC = math.cos(n/360*2*(math.pi))
    yS = math.sin(n/360*2*(math.pi))
    print(n, '           ', format(yS,'.4f'), '       ', format(yC,'.4f'))
    n = n + 10
    continue
    
