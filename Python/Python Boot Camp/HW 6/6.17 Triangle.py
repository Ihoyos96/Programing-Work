def isValid(side1, side2, side3):

    s = (side1+side2+side3)/2
    if side1 == side2 and side1 == side3 and side2 == side3 and side2 == side1 and side3 == side1 and side3 == side2:
         return "Triangle is Valid"
    else:
        return "Triangle is not Valid"



def area(n, n2, n3):
    s = (n+n2+n3)/2
    a = s*(s-n)*(s-n2)*(s-n3)
    area = a**(0.5)

    return area
