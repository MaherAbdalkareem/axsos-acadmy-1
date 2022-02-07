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
        print("Balance : " ,self.balance)
        return self
    def yield_interest(self):
        self.balance=(self.balance*self.int_rate)+self.balance
        return self


class user:
    def __init__(self,name,age,address):
        self.name=name
        self.age=age
        self.address=address
        self.account=[bankAccount(int_rate=0.02,balance=0)]
        
    def make_deposit(self,amount,index):
        self.account.append(bankAccount(int_rate=0.02,balance=0))
        self.account[index].balance +=amount
        
        return self
    def make_withdrawal(self,amount,index):
        self.account.append(bankAccount(int_rate=0.02,balance=0))
        self.account[index].balance-=amount
        return self
    def display_user_balance(self,index):
        print(self.account[index].balance)
        return self
    


acc1=bankAccount(0.02,0) #index 0
acc2=bankAccount(0.02,0) #index 1
acc3=bankAccount(0.02,0)
acc4=bankAccount(0.02,0)


maher=user("maher",24,"baqa")
abed=user("abed",24,"baqa")
maher.make_deposit(100,0).make_deposit(200,2).make_withdrawal(100,2).make_deposit(200,3).display_user_balance(0).display_user_balance(2).display_user_balance(3)

