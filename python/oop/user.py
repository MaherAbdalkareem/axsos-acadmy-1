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
    def make_withdrawal(self,amount):
        self.account_withdrawal+=amount
        print(self.account_withdrawal)
    def display_user_balance(self):
        self.account_balance=self.account_deposit-self.account_withdrawal
        print(self.account_balance)
    def transfer_money(self,name,amount):
        self.account_balance=self.account_balance-amount
        name.account_balance=name.account_balance+amount
        print(self.name,"transfer money and his balance ",self.account_balance)
        print(name.name,"accepted money and his balance ",name.account_balance)



maher=user("maher",24,"baqa")
maher.make_deposit(200)
maher.make_deposit(200)
maher.make_deposit(200)
maher.make_withdrawal(100)
maher.display_user_balance()


abed=user("abed",25,"tulkareem")
abed.make_deposit(200)
abed.make_deposit(200)
abed.make_withdrawal(100)
abed.make_withdrawal(100)


ahamd=user("ahamd",30,"nablus")
ahamd.make_withdrawal(100)
ahamd.make_withdrawal(100)
ahamd.make_withdrawal(100)
ahamd.make_deposit(200)


ahamd.transfer_money(maher,400)

