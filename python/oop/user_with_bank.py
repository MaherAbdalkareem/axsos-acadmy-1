class bankAccount:
    def __init__(self,int_rate=0.01,balance=0,name="acc"):
        self.int_rate=int_rate
        self.balance=balance
        self.name=name
    def deposit(self, amount,name):
        name.balance+=amount
        return self
    def withdraw (self,amount,name):
        if name.balance<amount :
            print("Insufficient funds: Charging a $5 fee and deduct $5")
        else:
            name.balance-=amount
        return self
    def display_account_info(self,name):
        print("Balance : ",name.balance)
        return self
    def yield_interest(self,name):
        name.balance=(name.balance*name.int_rate)+name.balance
        return self

class user:
    def __init__(self,name,age,address):
        self.name=name
        self.age=age
        self.address=address
        self.account=bankAccount(int_rate=0.02,balance=0,name="acc")
    def make_deposit(self,amount,name):
        name.account.deposit(amount)
        return self
    def make_withdrawal(self,amount,name):
        name.account.withdraw(amount)
        return self
    def display_user_balance(self,name):
        name.account.display_account_info()
        return self





account1=bankAccount(0.03,0,"account1")
account2=bankAccount(0.04,0,"account2")
account3=bankAccount(0.02,0,"account3")

maher=user("maher",24,"baqa")
maher.account.deposit(100,account1).deposit(200,account2).display_account_info(account2)
