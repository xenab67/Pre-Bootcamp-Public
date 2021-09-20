class BankAccount:
    accounts = []
    def __init__(self, int_rate, balance):
        self.int_rate= int_rate
        self.balance = balance
        BankAccount.accounts.append(self)
    
    def deposit (self, amount):
        self.balance += amount
        return self

    def withdraw (self, amount):
        if (self.balance-amount) >=0:
            self.balance -=amount
        else:
            print("Insufficient funds: Charging a $5 fee.")
            self.balance -= 5
        return self

    def display_account_info(self):
        # print(f"Balance: ${self.balance}")    #not needed for assignment
        return f"{self.balance}"

    def yield_interest(self):
        if self.balance > 0:
            self.balance += (self.balance * self.int_rate)
        return self

    @classmethod
    def print_all_accounts(cls):
        for account in cls.accounts:
            account.display_account_info()




class User:
    def __init__(self, name,):
        self.name = name
        self.account={
            "checking" : BankAccount(.03, 3460),
            "savings" : BankAccount(.07, 7200)
        }

    # def make_deposit(self, amount):
    #     self.balance += amount                  #Code not needed for assignment, but wanted to leave for reference
    #     return self

    # def make_withdrawl(self, amount):
    #     self.balance -= amount
    #     return self

    def display_user_balance(self):
        print(f"User: {self.name}, Checking Balance: ${self.account['checking'].display_account_info()}")
        print(f"User: {self.name}, Savings Balance: ${self.account['savings'].display_account_info()}")
        return self

    def transfer_money(self,user,amount):
        self.account_balance -=amount
        user.account_balance += amount
        self.display_user_balance()
        user.display_user_balance()
        return self

xena=User("Xena")
xena.account['savings'].deposit(220)
xena.display_user_balance()










#DONT NEED THE FOLLOWING CODE, BUT KEEPING FOR REFERENCE 
# xena = User("Xena B")
# austin = User("Austin P")
# bentley = User ("Bentley B")

# #>>>>1st User
# xena.make_deposit(150).make_deposit(200).make_deposit(30).make_withdrawl(144).display_user_balance()
# #>>>>2nd User
# austin.make_deposit(421).make_deposit(3200).make_withdrawl(1207).make_withdrawl(167).display_user_balance()
# #>>>>3rd User
# bentley.make_deposit(790).make_withdrawl(320).make_withdrawl(260).make_withdrawl(413).display_user_balance()

# xena.transfer_money(bentley, 205)