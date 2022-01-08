package com.Responsi;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hashtable<Integer, String> nasabah = new Hashtable<>();
        nasabah.put(18292, "PAUZI");
        nasabah.put(18270, "DEWA");
        nasabah.put(18283, "ANDI");
        nasabah.put(18284, "WARDANA");
        nasabah.put(18277, "AMIN");

        System.out.print("Masukkan PIN anda: ");
        int id = input.nextInt();
        customer atm = new customer(id, 1234, 3000000);
        int trial = 0;
        //pengulangan pin
        while(id != atm.checkCustPin() && trial < 3){
            System.out.print("Pin anda salah. masukkan kembali pin anda: ");
            id = input.nextInt();
            trial += 1;
            if (trial == 3) {
                System.out.println("ATM terblokir");
                System.exit(0);
            }
        }
        int penarikan = 1;
        while (true){
            System.out.print("\n1. Penarikan\n2. Info Saldo\n3. Transfer\n4. Keluar\nPilihan:");
            int pilih = input.nextInt();
            switch (pilih) {
                case 1 -> {
                    //Penarikan
                    System.out.println("||====||Penarikan||====||");
                    System.out.print("Masukkan nominal yang ingin ditarik:");
                    int nominal = input.nextInt();
                    if (nominal > atm.checkCustBalance()) {
                        System.out.println("Maaf. Saldo sisa sekarang tidak cukup. transaksi gagal ");
                        break;
                    }
                    atm.withdrawBalance(nominal);
                    if (penarikan % 3 == 0) {
                        int bonus = nominal * 3 / 100;
                        System.out.println("Anda mendapatkan bonus sebesar " + bonus);
                        atm.setCustBalance(atm.checkCustBalance()+bonus);
                    }
                    System.out.println("Transaksi Berhasil!");
                    penarikan+=1;
                    System.out.println("Saldo anda sekarang: " + atm.checkCustBalance());
                }
                case 2 -> {
                    //Info Saldo
                    System.out.println("||====||Info Saldo||====||");
                    System.out.println("Saldo anda sekarang: " + atm.checkCustBalance());
                    promptEnterKey();
                }
                case 3 -> {
                    //Transfer
                    System.out.println("||====||Transfer||====||");
                    System.out.print("Masukkan No Rekening:");
                    int rek = input.nextInt();
                    if(nasabah.get(rek) == null) {
                        System.out.println("Maaf. No rekening tidak ditemukan. transaksi gagal");
                        break;
                    }
                    System.out.print("Masukkan jumlah nominal:");
                    int nominal = input.nextInt();
                    if (nominal > atm.checkCustBalance()) {
                        System.out.println("Maaf. Saldo sisa sekarang tidak cukup. transaksi gagal");
                        break;
                    }
                    System.out.println("Transaksi Berhasil!");
                    System.out.println(nominal + " Berhasil ditransfer ke rekening " + rek + " atas nama " + nasabah.get(rek));
                    atm.withdrawBalance(nominal);
                    System.out.println("Saldo anda sekarang: " + atm.checkCustBalance());
                }
                case 4 -> {
                    //Keluar
                    System.out.println("||====||Keluar||====||");
                    System.exit(0);
                }
            }
        }
    }

    private static void promptEnterKey() {
        System.out.println("Press \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
