fo = open('this.txt', "r")

total_lines = 0
empty_lines = 0
total_char = 0

while (1):
    line = fo.readline()
    total_lines = (total_lines + 1)
    print(line)
    print(len(line))
    
    if (line == ''):
        total_lines = (total_lines - 1)
        break

    if (len(line) == 1 or 0):
        empty_lines = (empty_lines + 1)
        
    for ch in 'this.txt':
        total_char = total_char + 1

        
print(total_char)
print(total_lines)
print(empty_lines)
