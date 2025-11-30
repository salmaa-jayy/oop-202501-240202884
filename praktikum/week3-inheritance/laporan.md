# Laporan Praktikum Minggu 3 
Topik: [Inheritance (Kategori Produk)]

## Identitas
- Nama  : [Salma Zaidah]
- NIM   : [240202884]
- Kelas : [3 IKR B]

---

## Tujuan
(
1. Memahami konsep inheritance (pewarisan) dalam pemrograman berorientasi objek, yaitu kemampuan sebuah class untuk mewarisi atribut dan method dari class lain.
2. Menerapkan hubungan antara kelas induk (parent class) dan kelas turunan (child class) dalam program untuk mengurangi duplikasi kode dan meningkatkan modularitas.
3. Mengimplementasikan aksesibilitas atribut dan method (public, private, protected) dalam konteks inheritance.
4. Menguji kemampuan overriding dan extending method di kelas turunan untuk menyesuaikan fungsi sesuai kebutuhan program.
5. Meningkatkan pemahaman tentang penggunaan inheritance dalam membangun struktur program yang lebih rapi, efisien, dan mudah dikembangkan.
)

---

## Dasar Teori
(   
1. Inheritance adalah konsep OOP yang memungkinkan sebuah class mewarisi atribut dan method dari class lain untuk menghindari duplikasi kode. 
2. Superclass berfungsi sebagai class induk yang menyimpan atribut dan perilaku yang bersifat umum. 
3. Subclass adalah class turunan yang mewarisi fitur superclass dan dapat menambahkan atau mengubah fungsinya.
4. Keyword super digunakan oleh subclass untuk memanggil konstruktor atau method dari superclass.
5. Inheritance membantu membuat program lebih rapi, reusable, dan mudah dikembangkan, seperti pada sistem Agri-POS yang menurunkan class Produk ke Benih, Pupuk, dan AlatPertanian.
)

---

## Langkah Praktikum
(
1. Membuat Superclass Produk: Gunakan class Produk dari Bab 2 sebagai superclass.  
2.Membuat Subclass:
- Benih.java → atribut tambahan: varietas.
- Pupuk.java → atribut tambahan: jenis pupuk (Urea, NPK, dll).
- AlatPertanian.java → atribut tambahan: material (baja, kayu, plastik).
3. Membuat Main Class
- Instansiasi minimal satu objek dari tiap subclass.
- Tampilkan data produk dengan memanfaatkan inheritance.
4. Menambahkan CreditBy: Panggil class CreditBy untuk menampilkan identitas mahasiswa.
5. Commit dan Push: Commit dengan pesan: week3-inheritance. )

---

## Kode Program
(  
AlatPertanian.java
```
package main.java.com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private String material;

    public AlatPertanian(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama, harga, stok);
        this.material = material;
    }
    public String getMaterial() { 
        return material; 
    }
    public void setMaterial(String material) { 
        this.material = material; 
    }

    Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Material: " + material);
    }
}
```

Main.java
```
package com.upb.agripos.model;

public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    public String getVarietas() { 
        return varietas; 
    }
    public void setVarietas(String varietas) { 
        this.varietas = varietas; 
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Varietas: " + varietas);
    }
}

```

Produk.java
```
package main.java.com.upb.agripos.model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }

    public void tampilkanInfo() {
        System.out.println("Kode: " + kode);
        System.out.println("Nama: " + nama);
        System.out.println("Harga: " + harga);
        System.out.println("Stok: " + stok);
    }
}
```

Pupuk.java
```
package main.java.com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() { 
        return jenis; 
    }
    public void setJenis(String jenis) { 
        this.jenis = jenis; 
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis Pupuk: " + jenis);
    }
}
```

Credit.By
```
package main.java.com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + " - " + nama);
    }
}
```

MainInheritance.java
```
package main.java.com.upb.agripos.model;

import main.java.com.upb.agripos.model.*;
import main.java.com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        Benih b = new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64");
        Pupuk p = new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea");
        AlatPertanian a = new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja");

        System.out.println("\n=== Data Produk Pertanian ===");
        b.tampilkanInfo();
        System.out.println();
        p.tampilkanInfo();
        System.out.println();
        a.tampilkanInfo();

        CreditBy.print("<240202884>", "<Salma Zaidah>");
    }
}
```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
---

## Analisis
(
- Jelaskan bagaimana kode berjalan.  
Program membuat objek Benih, Pupuk, dan AlatPertanian yang semuanya mewarisi atribut dari class Produk. Saat tampilkanInfo() dipanggil, program menampilkan data dari Produk lalu menampilkan informasi tambahan dari masing-masing subclass. Semua proses dijalankan berurutan dari method main().
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  
Minggu sebelumnya program hanya memakai class dasar tanpa hubungan antar class, jadi setiap class berdiri sendiri.
Minggu ini sudah memakai inheritance, jadi ada hubungan induk–anak antara Produk dan subclass-nya. Dengan inheritance, kode jadi lebih rapi, tidak perlu menulis ulang atribut/method yang sama, dan lebih mudah dikembangkan.
- Kendala yang dihadapi dan cara mengatasinya.  
Selama praktikum, kendala utama adalah error pada struktur package, class yang tidak terbaca, dan import yang salah karena penempatan file belum sesuai. Masalah ini diatasi dengan menata ulang folder sesuai struktur package yang benar, memperbaiki path import, serta memastikan semua class berada di package yang sama dengan penulisan nama yang konsisten. Setelah itu program bisa berjalan normal.
)
---

## Kesimpulan
(Pada praktikum ini, konsep inheritance berhasil diterapkan untuk membuat struktur class yang lebih rapi dan mudah dikembangkan. Dengan menjadikan Produk sebagai superclass, lalu Benih, Pupuk, dan AlatPertanian sebagai subclass, kode menjadi lebih efisien karena fitur umum tidak perlu ditulis berulang. Pendekatan ini membuat aplikasi POS lebih mudah dikelola dan siap dikembangkan menjadi sistem yang lebih kompleks.)

---

## Quiz
(1. [Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan?]  
   **Jawaban:** Keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan adalah kita bisa menghindari duplikasi kode karena atribut dan method yang sama cukup ditulis sekali di superclass, sehingga struktur program lebih rapi, mudah diperluas, dan lebih efisien untuk dikelola.

2. [Bagaimana cara subclass memanggil konstruktor superclass?]  
   **Jawaban:** Subclass dapat memanggil konstruktor superclass dengan menggunakan keyword super(...) pada baris pertama konstruktor, lalu mengirimkan nilai-nilai yang dibutuhkan oleh konstruktor superclass tersebut.

3. [Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat Pertanian yang bisa dijadikan subclass.]  
   **Jawaban:** 
   Beberapa contoh kasus di POS pertanian yang bisa dijadikan subclass lain dari Produk adalah:
   -  Pestisida → punya atribut tambahan seperti jenis (insektisida/herbisida), dosis pemakaian, atau masa kadaluarsa.
   -  Bibit Buah → atribut khusus seperti jenis tanaman, umur bibit, dan media tanam.
   - Pakan Ternak → atribut seperti kandungan nutrisi, jenis hewan, dan berat kemasan.
   - Obat Tanaman → atribut khusus seperti fungsi obat dan aturan penggunaan.
   Semua ini bisa menjadi subclass karena masih termasuk kategori produk pertanian tetapi memiliki atribut tambahan yang berbeda dari produk umum.
   )
