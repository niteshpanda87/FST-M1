numbers1 = list(input("Enter the list of numbers: ").split(","))
numbers2 = list(input("Enter the list of numbers: ").split(","))

# numbers1 = [1, 2, 5]
# numbers2 = [7, 4, 6]

newnumber = []

for number in numbers1:
    if int (number) % 2 != 0:
        newnumber.append(number)
for number in numbers2:
    if int (number) % 2 == 0:
        newnumber.append(number)
print(newnumber)