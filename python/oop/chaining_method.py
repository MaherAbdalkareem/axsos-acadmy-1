class user:
    def __init__(self,name,age,address):
        self.name=name
        self.age=age
        self.address=address
        self.account_deposit=0
        self.account_withdrawal=0
        self.account_balance=0
    def make_deposit(self,amount):
        self.account_deposit+=amount
        print(self.account_deposit)
        return self
    def make_withdrawal(self,amount):
        self.account_withdrawal+=amount
        print(self.account_withdrawal)
        return self
    def display_user_balance(self):
        self.account_balance=self.account_deposit-self.account_withdrawal
        print(self.account_balance)
        return self
    def transfer_money(self,name,amount):
        self.account_balance=self.account_balance-amount
        name.account_balance=name.account_balance+amount
        print(self.name,"transfer money and his balance ",self.account_balance)
        print(name.name,"accepted money and his balance ",name.account_balance)
        return self 



maher=user("maher",24,"baqa")
maher.make_deposit(200).make_deposit(200).make_deposit(200).make_withdrawal(100).display_user_balance()

abed=user("abed",25,"tulkareem")
abed.make_deposit(200).make_deposit(200).make_withdrawal(100).make_withdrawal(100).display_user_balance()

ahamd=user("ahamd",30,"nablus")
ahamd.make_withdrawal(100).make_withdrawal(100).make_withdrawal(100).make_deposit(200).display_user_balance()

ahamd.transfer_money(maher,400)

