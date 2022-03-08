public class BankTest {
    public static void main(String[] args) {

        BankAccount account1 = new BankAccount();

        account1.setCheckBalance(100);
        account1.setSavingBalance(200);

        account1.deposit(100,"saving");
        account1.deposit(200,"check");

        account1.withdraw(50,"saving");
        account1.withdraw(30,"check");

        account1.display();
        System.out.println(account1.accountNumber);
    }
}
