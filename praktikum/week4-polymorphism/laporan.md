# Laporan Praktikum Minggu 4 (sesuaikan minggu ke berapa?)
Topik: [Polymorphism (Info Produk)]

## Identitas
- Nama  : [Salma Zaidah]
- NIM   : [240202884]
- Kelas : [3 IKR B]

---

## Tujuan
(
1. Mahasiswa mampu menjelaskan konsep polymorphism dalam OOP.
2. Mahasiswa mampu membedakan method overloading dan overriding.
3. Mahasiswa mampu mengimplementasikan polymorphism (overriding, overloading, dynamic binding) dalam program.
4. Mahasiswa mampu menganalisis contoh kasus polymorphism pada sistem nyata (Agri-POS).)

---

## Dasar Teori
(Polymorphism memungkinkan satu method dipanggil ke berbagai objek, tetapi tiap objek merespons dengan caranya sendiri. Konsep ini mencakup overloading (nama method sama, parameter berbeda) dan overriding (subclass mengganti method superclass). Pada Agri-POS, misalnya method getInfo() di class Produk dioverride oleh Benih, Pupuk, dan AlatPertanian sehingga masing-masing menampilkan detail sesuai jenis produknya. Dengan polymorphism, kode jadi lebih fleksibel, efisien, dan mudah dikembangkan.)

---

## Langkah Praktikum
(Overloading
1. Tambahkan method tambahStok(int jumlah) dan tambahStok(double jumlah) pada class Produk.
Overriding
2. Tambahkan method getInfo() pada superclass Produk.
Override method getInfo() pada subclass Benih, Pupuk, dan AlatPertanian.
Dynamic Binding
3. Buat array Produk[] daftarProduk yang berisi objek Benih, Pupuk, dan AlatPertanian.
Loop array tersebut dan panggil getInfo(). Perhatikan bagaimana Java memanggil method sesuai jenis objek aktual.
Main Class
4. Buat MainPolymorphism.java untuk mendemonstrasikan overloading, overriding, dan dynamic binding.
CreditBy
5. Tetap panggil CreditBy.print("<NIM>", "<Nama>").
6. Commit dan Push
7. Commit dengan pesan: week4-polymorphism.)

---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

```java
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
   Program membuat array berisi berbagai objek produk (Benih, Pupuk, AlatPertanian, ObatHama) tetapi semuanya diperlakukan sebagai Produk. Saat program melakukan perulangan dan memanggil tampilkanInfo(), setiap objek menampilkan informasi sesuai class masing-masing karena terjadi overriding. Jadi walaupun dipanggil lewat tipe Produk, hasil output tetap sesuai bentuk aslinya (inilah polymorphism).
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  
   Minggu sebelumnya fokus pada enkapsulasi dan pembuatan class/objek secara dasar — hanya memanggil method dan mengatur atribut melalui getter/setter.
   Minggu ini sudah masuk pewarisan dan polymorphism, jadi class tidak berdiri sendiri lagi, tetapi saling terhubung melalui inheritance, dan method superclass dapat diubah/ditimpa (override) di subclass untuk menghasilkan output berbeda.
- Kendala yang dihadapi dan cara mengatasinya.  
   Kendala terbesar adalah error import dan struktur package, sehingga class tidak dikenali (mis. Benih cannot be resolved to a type). Error ini muncul karena file belum berada di folder package yang sesuai.
   Solusinya dengan menyamakan struktur folder dan deklarasi package, lalu menyesuaikan import agar program dapat menemukan class yang dibutuhkan. Setelah struktur benar, program baru bisa dijalankan tanpa error.
)
---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
Contoh: Pemanfaatan konsep pewarisan (inheritance) dan polymorphism pada Agri-POS membuat pengelolaan berbagai jenis produk menjadi jauh lebih fleksibel dan efisien. Meskipun setiap produk (Benih, Pupuk, Alat Pertanian, Obat Hama, dan lainnya) memiliki karakteristik berbeda, semuanya dapat diperlakukan sebagai objek dari superclass Produk sehingga mempermudah proses pembacaan, pengolahan, dan pengembangan fitur ke depannya. Mekanisme overriding memungkinkan setiap subclass menampilkan informasi dengan cara yang berbeda, sementara dynamic binding memastikan method yang tepat dieksekusi sesuai tipe objek saat program berjalan. Dengan demikian, aplikasi menjadi lebih terstruktur, mudah diperluas, mengurangi duplikasi kode, serta mendukung skalabilitas sistem POS yang lebih kompleks.)

---

## Quiz
(1. [Apa perbedaan overloading dan overriding?]  
   **Jawaban:** Perbedaan utama antara overloading dan overriding terletak pada cara method digunakan: overloading adalah kondisi ketika sebuah class memiliki method dengan nama yang sama tetapi parameter berbeda, sedangkan overriding terjadi ketika subclass mengganti implementasi method milik superclass dengan nama dan parameter yang sama. Dalam mekanisme dynamic binding, Java menentukan method mana yang akan dieksekusi berdasarkan tipe objek sebenarnya pada saat program berjalan (runtime), bukan berdasarkan tipe referensi variabelnya. Contoh penerapan polymorphism di sistem POS selain produk pertanian dapat ditemukan pada sistem pembayaran, di mana class Tunai, Debit, dan EWallet sama-sama dianggap sebagai objek Pembayaran, namun masing-masing memberikan perilaku yang berbeda ketika method prosesPembayaran() dipanggil sesuai dengan jenis transaksinya. 

2. [Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?]  
   **Jawaban:** Java memilih method yang dipanggil berdasarkan tipe objek yang sebenarnya saat program dijalankan (runtime), bukan berdasarkan tipe referensinya. Jadi kalau referensinya Produk, tapi objeknya Pupuk, maka method dari Pupuk yang dijalankan.

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:** Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian 
   ```java
   Pembayaran[] daftarPembayaran = {
      new Tunai(200000),
      new Debit("BCA", 150000),
      new EWallet("OVO", 100000)
   };
   for (Pembayaran p : daftarPembayaran) {
        p.prosesPembayaran(); // tiap jenis pembayaran punya cara proses berbeda
   }
 )
