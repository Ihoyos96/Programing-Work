Minutes = eval(input("How many minutes do you want to convert"))

Years = int((Minutes/525600))
Days = int(((Minutes/60)/24)%365)

print(Minutes, end=" ")
print("is approximately", end=" ")
print(Years, end="")
print(" years and approximately", end=" ")
print(Days, end=" ")
print("days")


