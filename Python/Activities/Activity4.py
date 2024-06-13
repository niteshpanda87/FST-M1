
user1 = input("Enter User1 name: ")
user2 = input("Enter User2 name: ")

while True:

    print("Choose your option. 1 - Rock 2- Scissior 3 - paper")
    input1 = int (input(f"Enter one of the option for {user1}: "))
    input2 = int(input(f"Enter one of the option for {user2}: "))

    if input1 == input2 :
        print("It's a Draw.")
    elif input1 == 1:
        if input2 == 2:
            print(f"Rock beat scissior.{user1} WON.")
        else:
            print(f"Paper beat rock.{user2} WON.")
    elif input1 == 2:
        if input2 == 1:
            print(f"Rock beat scissior.{user2} WON.")
        else :
            print(f"scissior beat paper.{user1} WON.")
    elif input1 ==3:
        if input2 == 1:
            print(f"Paper beat Rock.{user1} WON.")
        else:
            print(f"scissior beat paper.{user2} WON.")
    else:
        print("Please enter a Valid Input.")

    repeat = input("Do you want to Play again? Type Yes or No: ").lower()

    if (repeat == "yes"):
        pass
    elif (repeat == "no"):
        raise SystemExit
    else:
        print("You have entered invalid Option.Exiting Now")
        raise SystemExit
