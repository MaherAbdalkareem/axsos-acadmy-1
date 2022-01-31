class bankAccount:
    def __init__(self,int_rate=0.01,balance=0):
        self.int_rate=int_rate
        self.balance=balance
    def deposit(self, amount):
        self.balance+=amount
        return self
    def withdraw (self,amount):
        if self.balance<amount :
            print("Insufficient funds: Charging a $5 fee and deduct $5")
        else:
            self.balance-=amount
        return self
    def display_account_info(self):
        print("Balance : ",self.balance)
        return self
    def yield_interest(self):
        self.balance=(self.balance*self.int_rate)+self.balance
        return self

account1=bankAccount(0.05,100)
account1.deposit(1000) .deposit(1000) .deposit(1000) .withdraw(5000) .yield_interest() .display_account_info()

account2=bankAccount(0.04,500)
account2.deposit(1500).deposit(1500) .withdraw(500).withdraw(500).withdraw(500).withdraw(500) .yield_interest() .display_account_info()