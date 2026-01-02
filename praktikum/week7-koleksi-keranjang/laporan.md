# Laporan Praktikum Minggu 7
Topik: [Collections dan Implementasi Keranjang Belanja]

## Identitas
- Nama  : [Salma Zaidah]
- NIM   : [240202884]
- Kelas : [3 IKR B]

---

## Tujuan
(
a. Menjelaskan konsep collection dalam Java (List, Map, Set).
b. Menggunakan ArrayList untuk menyimpan dan mengelola objek.
c. Mengimplementasikan Map atau Set sesuai kebutuhan pengelolaan data.
d. Melakukan operasi dasar pada collection: tambah, hapus, dan hitung total.
e. Menganalisis efisiensi penggunaan collection dalam konteks sistem Agri-POS.)

---

## Dasar Teori
(
1. Collections Framework
Java Collections Framework menyediakan struktur data untuk mengelola objek secara dinamis dan efisien.
Struktur utama:
a. List (implementasi: ArrayList) — Terurut, dapat menyimpan elemen duplikat.
b. Map (implementasi: HashMap) — Menyimpan pasangan key–value, akses cepat berdasarkan key.
c. Set (implementasi: HashSet) — Tidak menerima duplikat dan tidak mempertahankan urutan.
)
---
2. Studi Kasus: Keranjang Belanja Agri-POS
Keranjang belanja harus dapat:
a. Menambahkan produk
b. Menghapus produk
c. Menampilkan isi keranjang
d. Menghitung total nilai transaksi
e. Menangani jumlah (quantity) menggunakan Map
f. Kasus ini mencerminkan penggunaan struktur data dalam aplikasi nyata seperti POS.
---

## Langkah Praktikum
(
1. Membuat Class Product
2. Implementasi Keranjang dengan ArrayList
3. Main Program 
4. Implementasi Alternatif Menggunakan Map (Dengan Quantity)
)

---

## Kode Program
(
Menggunakan ArrayList
```java
package main.java.com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        System.out.println("Hello, I am Salma Zaidah-240202884 (Week7)");

        Product p1 = new Product("P01", "Beras", 45000);
        Product p2 = new Product("P02", "Pupuk", 30000);
        Product p3 = new Product("P03", "Insektisida", 150000);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);
        cart.printCart();
        
        System.out.println("\nSetelah menghapus " + p1.getCode() + " " + p1.getName() + " dari keranjang:");
        cart.removeProduct(p1);
        cart.printCart();
    }
}
```

Menggunakan Map
```java
package main.java.com.upb.agripos;

public class MainCartMap {
    public static void main(String[] args) {
        System.out.println("Hello, I am Salma Zaidah-240202884 (Week7)");

        Product p1 = new Product("P01", "Beras", 45000);
        Product p2 = new Product("P02", "Pupuk", 30000);
        Product p3 = new Product("P03", "Insektisida", 150000);

        ShoppingCartMap cart = new ShoppingCartMap();
        cart.addProduct(p1);
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p2);
        cart.addProduct(p3);
        cart.printCart();

        System.out.println("\nSetelah menghapus " + p1.getCode() + " " + p1.getName() + " dari keranjang:");
        
        cart.removeProduct(p1);
        cart.printCart();
    }
}
```
)
---

## Hasil Eksekusi
(  
![Screenshot hasil](./screenshots/hasil1week7.png)
![Screenshot hasil](./screenshots/hasil2week7.png)
)
---

## Analisis
(
Pada praktikum minggu ke-7, konsep Collections dimanfaatkan untuk membuat fitur keranjang belanja pada sistem Agri-POS. Fitur ini bertujuan untuk mengelola kumpulan data produk yang dipilih oleh pengguna secara lebih dinamis.

Dalam implementasinya, program menggunakan ArrayList untuk menyimpan objek Product. Setiap produk yang dipilih akan dimasukkan ke dalam keranjang, dan total harga dihitung dengan cara menelusuri seluruh isi collection. Selain itu, dicoba juga pendekatan lain menggunakan HashMap, di mana setiap produk disimpan bersama jumlah (quantity) pembeliannya, sehingga sistem menjadi lebih efisien dan mendekati kondisi nyata pada aplikasi POS.

Jika dibandingkan, ArrayList cocok digunakan untuk keranjang belanja yang sederhana, namun kurang efektif ketika produk yang sama dimasukkan berulang kali karena data akan tersimpan secara duplikat. Sebaliknya, Map lebih optimal karena setiap produk hanya disimpan satu kali dengan nilai quantity yang bisa disesuaikan.

Kendala utama yang muncul adalah sulitnya mengelola produk yang sama ketika menggunakan ArrayList. Untuk mengatasi hal tersebut, struktur data Map digunakan agar pengelolaan jumlah produk menjadi lebih rapi, efisien, dan mudah dikembangkan.
)
---

## Kesimpulan
(
Penggunaan Java Collections Framework sangat membantu dalam pengelolaan data secara dinamis. Dengan memanfaatkan ArrayList dan HashMap, sistem keranjang belanja Agri-POS dapat dibuat lebih efisien, terstruktur, dan mudah dikembangkan.
)

---

## Quiz
(
1. [Jelaskan perbedaan antara List, Map, dan Set.]  
   **Jawaban:** List menyimpan data terurut dan boleh duplikat, Map menyimpan pasangan key–value, sedangkan Set menyimpan data unik.

2. [Mengapa ArrayList cocok untuk keranjang belanja sederhana?]  
   **Jawaban:** Karena mudah digunakan, mendukung data terurut, dan efisien untuk jumlah data kecil. 

3. [Bagaimana Set mencegah duplikasi data?]  
   **Jawaban:** Set hanya mengizinkan satu elemen unik berdasarkan mekanisme equals dan hashCode.

4. [Kapan sebaiknya menggunakan Map dibandingkan List? Berikan contoh.] 
   **JAwaban:** Map digunakan ketika data memiliki pasangan key–value, contohnya produk dengan quantity pada keranjang belanja POS.
   )
