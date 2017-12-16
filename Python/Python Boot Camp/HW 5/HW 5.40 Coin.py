import random

globalHeads = 0
globalTails = 0

for i in range(1000000):
    flip = random.randrange(2)
    if flip == 0:
        globalHeads = globalHeads + 1
    else:
        globalTails = globalTails + 1

print('The coin landed heads ', globalTails, ' times.')
print('And tails ', globalHeads, ' times.')
