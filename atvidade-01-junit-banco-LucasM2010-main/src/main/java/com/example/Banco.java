package com.example;

public class Banco {
    private String accountHolder;
    private double balance;

    public Banco(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }    
    public static void main(String[] args) {
        
        Banco conta = new Banco("João", 1000.00);

        
        System.out.println("Saldo inicial: " + conta.getBalance());

       
        conta.deposit(500.00);
        System.out.println("Saldo após depósito de 500.00: " + conta.getBalance());

        
        boolean sucessoSaque = conta.withdraw(200.00);
        System.out.println("Saque bem-sucedido: " + sucessoSaque);
        System.out.println("Saldo após saque de 200.00: " + conta.getBalance());

       
        sucessoSaque = conta.withdraw(1500.00);
        System.out.println("Saque bem-sucedido: " + sucessoSaque);
        System.out.println("Saldo após tentativa de saque de 1500.00: " + conta.getBalance());

        
        conta.deposit(-100.00);
        System.out.println("Saldo após tentativa de depósito negativo: " + conta.getBalance());
    }
}
