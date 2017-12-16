def reverse(num):
  return int(str(num)[::-1])
def isPalindrome(num):
    newNum = int(str(num)[::-1])
    if num - newNum == 0:
        return "Palindrome"
    else:
        return "Not a Palindrome"
