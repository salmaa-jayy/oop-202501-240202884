package com.upb.agripos.model;

public class ObatHama extends Produk {
    private String jenisHama;

    public ObatHama(String kode, String nama, double harga, int stok, String jenisHama) {
        super(kode, nama, harga, stok);
        this.jenisHama = jenisHama;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis Hama   : " + jenisHama);
    }
}
