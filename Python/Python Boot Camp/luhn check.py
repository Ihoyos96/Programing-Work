import sys
import random

def doubler(digit):
    "Double digit, add its digits together if they are >= 10"
    digit = int(digit)
    digit = digit * 2
    
    if digit < 0:
        print("Error!  digit < 0 sent: " + str(digit))
        sys.exit(1)

    if digit > 18:
        print("Error!  digit > 18 sent: " + str(digit))
        sys.exit(1)

    if digit < 10:
        return digit

    return digit - 9

def reverse(str):
    "Reverse the string str"
    buf = ""
    a = 0
    while (a < len(str)):
        a += 1
        buf += str[-a]
    return buf
    
def check(cc):
    "Given a cc number (string), will return True if it passes mod10 check, False otherwise"
    cc = reverse(cc)

    a = 0
    total = 0
    while (a < len(cc)):
           if (a % 2) == 1:
               total = total + doubler(cc[a])
           else:
               total = total + int(cc[a])
           a += 1

    if (total % 10) == 0:
        return True
    else:
        return False

def make_number(prefix, length):
    "Generate a random number that starts with prefix and is length long that passes mod10"
    valid = False

    while not valid:
        cc = prefix
        while len(cc) < length:
            cc = cc + str(random.choice((0,1,2,3,4,5,6,7,8,9)))
        if check (cc):
            valid = True

    return cc

def make_invalid_number(prefix,length):
    "generate a random number that starts with prefix and is length long that fails the mod10 test"
    invalid = False

    while not invalid:
        cc = prefix
        while len(cc) < length:
            cc = cc + str(random.choice((0,1,2,3,4,5,6,7,8,9)))
        if not check (cc):
            invalid = True

    return cc        

def print_numbers(count):
    "Print count numbers that pass mod10 - example function"
    passed = 0
    while (passed < count):
        cc = make_number("4", 16)
        print(cc)
        passed = passed + 1

#print_numbers(10)
