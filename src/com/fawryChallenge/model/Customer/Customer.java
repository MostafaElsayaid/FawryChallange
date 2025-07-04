package com.fawryChallenge.model.Customer;

public class Customer {
    private int accountCount = 1;
    private int id;
    private Double Balance;

    public Customer( Double balance) {
        this.id = accountCount++;
        Balance = balance;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }

    public void reduceBalance(double amount){

        this.Balance-=amount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", Balance=" + Balance +
                '}';
    }
}
