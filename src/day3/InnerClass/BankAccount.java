package day3.InnerClass;

public class BankAccount {
    private double saldo;

    public BankAccount(double saldo){this.saldo=saldo;};
    public class Transaction{
        private double total;
        public Transaction(double total){this.total=total;}

        public void hitungTotal(){
            saldo +=total;
            System.out.println("transaksi sukses, saldo saat ini :"+saldo);
        }
    }

    public static void main(String[] args) {
        //masukin saldo dengan nilai awal seribu
        BankAccount account=new BankAccount(1000);
        //bikin objek transaksi dari innerClass dan lakukan transaksi gope
        BankAccount.Transaction transaction = account.new Transaction(500);
        //panggil method
        transaction.hitungTotal();
    }
}
