package com.Responsi;

public class customer {
    private int id;
    private int custPin;
    private int custBalance;

    public customer(int id, int custPin, int custBalance) {
        this.id = id;
        this.custPin = custPin;
        this.custBalance = custBalance;
    }

    public int checkCustPin() {
        return custPin;
    }

    public int checkCustBalance() {
        return custBalance;
    }

    public int setCustBalance(int custBalance) {
        this.custBalance = custBalance;
        return custBalance;
    }

    public int withdrawBalance(int nominal){
        this.custBalance -= nominal;
        return setCustBalance(custBalance);
    }
}
