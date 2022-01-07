package com.Responsi;

public class customer {
    private int id;
    private String nama;
    private int custPin;
    private int custBalance;
    private int custRek;

    public customer(int id, int custPin, int custBalance) {
        this.id = id;
        this.custPin = custPin;
        this.custBalance = custBalance;
    }

    public customer(String nama, int custRek) {
        this.nama = nama;
        this.custRek = custRek;
    }

    public int checkId() {
        return id;
    }

    public String checkNama() {
        return nama;
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
    public int depositBalance(int nominal){
        this.custBalance += nominal;
        return setCustBalance(custBalance);
    }
}
