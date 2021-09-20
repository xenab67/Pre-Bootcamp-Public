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
        print(f"Balance: ${self.balance}")
        return self

    def yield_interest(self):
        if self.balance > 0:
            self.balance += (self.balance * self.int_rate)
        return self

    @classmethod
    def print_all_accounts(cls):
        for account in cls.accounts:
            account.display_account_info()

firstAccount = BankAccount(.03, 2500)
secondAccount = BankAccount(.025, 7600)

firstAccount.deposit(264).deposit(439).deposit(62).withdraw(794).yield_interest().display_account_info()
secondAccount.deposit(4500).deposit(2190).withdraw(4900).withdraw(967).withdraw(813).withdraw(2300).yield_interest().display_account_info()