numbers = list(input("Enter the list of numbers: ").split(","))

firstnumber = numbers[0]
lastnumber = numbers[-1]

if firstnumber == lastnumber:
    print("True")
else:
    print("False")