package com.Responsi;

public class atm_card {
    private int defaultPin;
    private int defaultBalance;

    public atm_card(int defaultPin, int defaultBalance) {
        this.defaultPin = defaultPin;
        this.defaultBalance = defaultBalance;
    }

    public int cekPinAwal() {
        return defaultPin;
    }

    public int cekSaldoAwal() {
        return defaultBalance;
    }
}
