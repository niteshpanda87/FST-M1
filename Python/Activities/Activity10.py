# numbers = (10,4,5,20,21)

numbers =  input ("Enter the numbers seperated by ,:").split(',')

print("Number Divisible by 5 Are:")
for number in numbers:
    if int (number) % 5 == 0:
        print(number)