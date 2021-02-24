package com.atguigu.exec;

class Customer extends Thread {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            acct.topUp(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account();

        Customer a = new Customer(acct);
        a.setName("Customer a");
        Customer b = new Customer(acct);
        b.setName("Customer b");

        a.start();
        b.start();
    }
}

class Account {
    private int balance;

    Account(int balance) {
        this.balance = balance;
    }

    Account() {
        this.balance = 0;
    }
    //默认的锁是this，Account只有一个，不会出现线程安全问题
    public synchronized int topUp(int i) {
        this.balance += i;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " top up 1000.Account balance is " + this.balance);
        return this.balance;
    }

    public int show() {
        return this.balance;
    }
}
