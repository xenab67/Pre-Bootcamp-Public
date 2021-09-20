class User:
    def __init__(self, name,):
        self.name = name
        self.account_balance = 0

    def make_deposit(self, amount):
        self.account_balance += amount

    def make_withdrawl(self, amount):
        self.account_balance -= amount

    def display_user_balance(self):
        print(f"User: {self.name}, Balance: ${self.account_balance}")

    def transfer_money(self,user,amount):
        self.account_balance -=amount
        user.account_balance += amount
        self.display_user_balance()
        user.display_user_balance()

xena = User("Xena B")
austin = User("Austin P")
bentley = User ("Bentley B")

#>>>>1st User
xena.make_deposit(150)
xena.make_deposit(200)
xena.make_deposit(30)
xena.make_withdrawl(144)
xena.display_user_balance()
#>>>>2nd User
austin.make_deposit(421)
austin.make_deposit(3200)
austin.make_withdrawl(1207)
austin.make_withdrawl(167)
austin.display_user_balance()
#>>>>3rd User
bentley.make_deposit(790)
bentley.make_withdrawl(320)
bentley.make_withdrawl(260)
bentley.make_withdrawl(413)
bentley.display_user_balance()

xena.transfer_money(bentley, 205)