package com.upb.agripos.util;

import com.upb.agripos.model.*;

public class MainPolymorphism {
    public static void main(String[] args) {
        Produk[] daftarProduk = {
            new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64"),
            new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea"),
            new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja"),
            new ObatHama("OBH-301", "Pestisida", 75000, 20, "Serangga")
        };

        System.out.println("\n=== POLYMORPHISM PRODUK ===");
        for (Produk p : daftarProduk) {
            p.tampilkanInfo();
            System.out.println();
        }

        CreditBy.print("<240202884>", "<Salma Zaidah>");
    }
}
