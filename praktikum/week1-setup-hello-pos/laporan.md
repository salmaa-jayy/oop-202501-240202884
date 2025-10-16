# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: ["Paradigma Setup"]

## Identitas
- Nama  : [Salma Zaidah]
- NIM   : [240202884]
- Kelas : [3 IKR B]

---

## Tujuan
(Mahasiswa telah memahami konsep class dan object, serta mampu membuat class Produk dengan menerapkan prinsip enkapsulasi.)

---

## Dasar Teori
1. Class merupakan cetak biru (blueprint) dari suatu objek, sedangkan object adalah instansiasi nyata dari class tersebut. 
2. Object adalah instansiasi dari class.  
3. Procedural: menulis langkah-langkah secara berurutan (menggunakan fungsi atau prosedur).
4. OOP: menggunakan class dan object untuk mengorganisasi kode.
5. Functional: menggunakan fungsi lambda expression dan functional interface seperti BiConsumer untuk menulis kode yang lebih ringkas dan modular.
6. Pemrograman OOP dan fungsional mendorong pembuatan kode yang terpisah ke dalam class atau fungsi agar mudah dibaca, dikelola, serta digunakan ulang (reusability). 

---

## Langkah Praktikum
1. **Setup Project**
   - Pastikan sudah menginstall **JDK** (Java Development Kit), **IDE** (misal: IntelliJ IDEA, VS Code, NetBeans), **Git**, **PostgreSQL**, dan **JavaFX** di komputer.
   - Buat folder project `oop-pos-<nim>`.
   - Inisialisasi repositori Git.
   - Buat struktur awal `src/main/java/com/upb/agripos/`.
   - Pastikan semua tools dapat berjalan (uji dengan membuat dan menjalankan program Java sederhana).

2. **Program Sederhana dalam 3 Paradigma**
   - Prosedural: program untuk menghitung total harga dua produk.
   - OOP: class `Produk` dengan atribut nama dan harga, buat minimal tiga objek, lalu hitung total.  
   - Fungsional: gunakan `Stream` atau lambda untuk menghitung total harga dari minimal tiga objek.  

3. **Commit dan Push**
   - Commit dengan pesan: `week1-setup-hello-pos`. 
---

## Kode Program
```java
package main.java.com.upb.agripos;

// HelloFunctional.java
import java.util.function.BiConsumer;

public class HelloFunctional {
    public static void main(String[] args) {
        BiConsumer<String, String> sapa =
            (nama, nim) -> System.out.println("Hello World, I am " + nama + " - " + nim);
        
        sapa.accept("Salma", "240202884");
    }
}

```;
```

---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
---

## Analisis
(
- Jelaskan bagaimana kode berjalan.  
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  
- Kendala yang dihadapi dan cara mengatasinya.  
)
---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
Contoh: *Dengan menggunakan class dan object, program menjadi lebih terstruktur dan mudah dikembangkan.*)

---

## Quiz
(1. [Tuliskan kembali pertanyaan 1 dari panduan]  
   **Jawaban:** …  

2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **Jawaban:** …  

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:** …  )
