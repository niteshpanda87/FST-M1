numbers = list(input("Enter the list of numbers: ").split(","))
sum = 0

for number in numbers:
    sum += int(number)
print(sum)