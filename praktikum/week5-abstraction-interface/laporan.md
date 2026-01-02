# Laporan Praktikum Minggu 6
Topik: [Abstraction (Abstract Class & Interface)]

## Identitas
- Nama  : [Salma Zaidah]
- NIM   : [240202884]
- Kelas : [3 IKR B]

---

## Tujuan
(
a. mampu menjelaskan perbedaan abstract class dan interface.
b. mampu mendesain abstract class dengan method abstrak sesuai kebutuhan kasus.
c. mampu membuat interface dan mengimplementasikannya pada class.
d. mampu menerapkan multiple inheritance melalui interface pada rancangan kelas.
e. mampu mendokumentasikan kode (komentar kelas/method, README singkat pada folder minggu)
.)

---

## Dasar Teori
(
   Abstraksi adalah konsep OOP yang digunakan untuk menyederhanakan sistem dengan menampilkan fitur utama dan menyembunyikan detail implementasi yang tidak perlu.

Abstract class digunakan ketika terdapat atribut dan method dasar yang sama, tetapi tidak semua method dapat langsung diimplementasikan.

Interface berfungsi sebagai kontrak yang harus diikuti oleh class lain dan memungkinkan penerapan multiple inheritance.

Abstract class cocok untuk class yang memiliki shared state, sedangkan interface digunakan untuk mendefinisikan kemampuan tertentu.

Dalam sistem Agri-POS, proses pembayaran dapat dimodelkan menggunakan abstract class dan interface agar sistem lebih fleksibel dan mudah dikembangkan.
)

---

## Langkah Praktikum
(
1. Abstract Class – Pembayaran Buat Pembayaran (abstract) dengan field invoiceNo, total dan method:
double biaya() (abstrak) → biaya tambahan (fee).
boolean prosesPembayaran() (abstrak) → mengembalikan status berhasil/gagal.
double totalBayar() (konkrit) → return total + biaya();.

2. Subclass Konkret
Cash → biaya = 0, proses = selalu berhasil jika tunai >= totalBayar().
EWallet → biaya = 1.5% dari total; proses = membutuhkan validasi.

3. Interface
Validatable → boolean validasi(); (contoh: OTP).
Receiptable → String cetakStruk();

4. Multiple Inheritance via Interface
EWallet mengimplementasikan dua interface: Validatable, Receiptable.
Cash setidaknya mengimplementasikan Receiptable.

5. Main Class
Buat MainAbstraction.java untuk mendemonstrasikan pemakaian Pembayaran (polimorfik).
Tampilkan hasil proses dan struk. Di akhir, panggil CreditBy.print("[NIM]", "[Nama]").
Commit dan Push Commit dengan pesan: week5-abstraction-interface.
)

---

## Kode Program
(
1. Receiptable  
```java
package main.java.com.upb.agripos.model.kontrak;

public interface Receiptable {
    String cetakStruk();
}
```
2. Validatable
```java
package main.java.com.upb.agripos.model.kontrak;

public interface Validatable {
    boolean validasi(); // misal validasi OTP/ PIN
}
```
3. Cash 
```java
package main.java.com.upb.agripos.model.pembayaran;

import main.java.com.upb.agripos.model.kontrak.Receiptable;

public class Cash extends Pembayaran implements Receiptable {
    private double tunai;

    public Cash(String invoiceNo, double total, double tunai) {
        super(invoiceNo, total);
        this.tunai = tunai;
    }

    @Override
    public double biaya() {
        return 0.0;
    }

    @Override
    public boolean prosesPembayaran() {
        return tunai >= totalBayar(); // sederhana: cukup uang tunai
    }

    @Override
    public String cetakStruk() {
        return String.format("INVOICE %s | TOTAL: %.2f | BAYAR CASH: %.2f | KEMBALI: %.2f",
                invoiceNo, totalBayar(), tunai, Math.max(0, tunai - totalBayar()));
    }
}
```
4. EWallet
```java
package main.java.com.upb.agripos.model.pembayaran;

import main.java.com.upb.agripos.model.kontrak.Receiptable;
import main.java.com.upb.agripos.model.kontrak.Validatable;

public class EWallet extends Pembayaran implements Validatable,Receiptable {

    private String akun;
    private String otp; // sederhana untuk simulasi

    public EWallet(String invoiceNo, double total, String akun, String otp) {
        super(invoiceNo,total);
        this.akun = akun;
        this.otp = otp;
    }

    @Override
    public double biaya() {
        return total * 0.015; // 1.5% fee
    }

    @Override
    public boolean validasi() {
        return otp != null && otp.length() == 6; // contoh validasi sederhana
    }

    @Override
    public boolean prosesPembayaran() {
        return validasi(); // jika validasi lolos, anggap berhasil
    }

    @Override
    public String cetakStruk() {
        return String.format("INVOICE %s | TOTAL+FEE: %.2f | E-WALLET: %s | STATUS: %s",
                invoiceNo, totalBayar(), akun, prosesPembayaran() ? "BERHASIL" : "GAGAL");
    }
}
```
5. Pembayaran
```java
package main.java.com.upb.agripos.model.pembayaran;

public abstract class Pembayaran {

    protected String invoiceNo;
    protected double total;

    public Pembayaran(String invoiceNo, double total) {
        this.invoiceNo = invoiceNo;
        this.total = total;
    }

    public Pembayaran() {
    }

    public abstract double biaya();               // fee/biaya tambahan
    public abstract boolean prosesPembayaran();   // proses spesifik tiap metode

    public double totalBayar() {
        return total + biaya();
    }

    public String getInvoiceNo() { return invoiceNo; }
    public double getTotal() { return total; }

}
```
6. TransferBank
```java
package main.java.com.upb.agripos.model.pembayaran;

import main.java.com.upb.agripos.model.kontrak.Receiptable;
import main.java.com.upb.agripos.model.kontrak.Validatable;

public class TransferBank extends Pembayaran implements Receiptable, Validatable {
    String noRek;
    boolean pin;
    
    public TransferBank(String invoiceNo, double total, String noRek, boolean pin) {
        super(invoiceNo, total);
        this.noRek = noRek;
        this.pin = pin;
    }

    @Override
    public String cetakStruk() {
        return String.format("INVOICE %s | TOTAL: %s  | Transfer Bank: %s | STATUS: %s",
                invoiceNo, totalBayar(), noRek, prosesPembayaran() ? "BERHASIL" : "GAGAL");
    }

    @Override
    public boolean validasi() {
        return total >= 3500 && pin == true && noRek.length()==16 ;
    }

    @Override
    public double biaya() {
        return 0;
    }

    @Override
    public boolean prosesPembayaran() {
        return validasi();
    }
}
```
7. CreditBy
```java
package main.java.com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + " - " + nama);
    }
}
```
8. MainAbstraction
```java
package main.java.com.upb.agripos.util;


import main.java.com.upb.agripos.model.kontrak.Receiptable;
import main.java.com.upb.agripos.model.pembayaran.Cash;
import main.java.com.upb.agripos.model.pembayaran.EWallet;
import main.java.com.upb.agripos.model.pembayaran.Pembayaran;
import main.java.com.upb.agripos.model.pembayaran.TransferBank;

public class MainAbstraction {
    public static void main(String[] args) {
    Pembayaran cash = new Cash("INV-001", 150000, 120000);
    Pembayaran ew = new EWallet("INV-002", 100000, "user@ewallet", "123456");
    Pembayaran tb = new TransferBank("INV-003", 500000,"2913100705067777",true);

    System.out.println(((Receiptable) cash).cetakStruk());
    System.out.println(((Receiptable) ew).cetakStruk());
        System.out.println(((Receiptable) tb).cetakStruk());

    CreditBy.print("240202884", "Salma Zaidah");
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
Pada program ini, konsep abstraction diterapkan untuk memisahkan bagian umum dan bagian khusus dari sistem pembayaran pada Agri-POS. Class Pembayaran berperan sebagai abstract class yang menyimpan atribut dasar seperti invoiceNo dan total, serta menyediakan kerangka method abstrak seperti biaya() dan prosesPembayaran(). Selanjutnya, class Cash, EWallet, dan TransferBank mengimplementasikan method tersebut sesuai dengan karakteristik masing-masing jenis pembayaran.

Selain itu, interface Validatable dan Receiptable digunakan untuk mendefinisikan perilaku tambahan, seperti proses validasi PIN atau OTP serta pencetakan struk pembayaran. Dengan adanya interface, class yang membutuhkan fungsi tersebut dapat mengimplementasikannya tanpa harus terikat pada satu hierarki class tertentu, contohnya EWallet dan TransferBank yang memerlukan validasi dan bukti transaksi.

Jika dibandingkan dengan praktikum minggu sebelumnya yang membahas polymorphism pada produk, praktikum minggu ini lebih menekankan pada abstraksi dan perancangan kontrak perilaku. Minggu sebelumnya fokus pada hubungan is-a dan overriding method, sedangkan minggu ini memperkenalkan konsep can-do melalui interface serta pentingnya desain struktur program yang lebih rapi dan terencana.

Kendala yang sering muncul selama praktikum antara lain kesalahan saat menginstansiasi abstract class, lupa mengimplementasikan seluruh method dari interface, serta kesalahan casting ke interface seperti (Receiptable) obj. Kendala tersebut dapat diatasi dengan memastikan class konkret mengimplementasikan semua method yang diwajibkan, serta memahami bahwa hanya objek yang benar-benar mengimplementasikan interface tertentu yang dapat digunakan melalui interface tersebut. 
)
---

## Kesimpulan
(
Praktikum minggu ini menunjukkan bahwa penerapan abstraction sangat membantu dalam mengurangi kompleksitas program dengan cara memisahkan bagian umum dan bagian yang bersifat khusus. Abstract class dimanfaatkan untuk menyimpan struktur dasar dan perilaku umum yang dimiliki oleh beberapa class, sedangkan interface digunakan sebagai kontrak perilaku tambahan yang bisa diterapkan pada berbagai class sesuai kebutuhan. Dengan mengombinasikan abstract class dan interface, program menjadi lebih fleksibel, tersusun rapi, mudah dikembangkan, serta memungkinkan penerapan multiple inheritance secara aman tanpa membuat struktur kode menjadi rumit.
)

---

## Quiz
(
1. [Jelaskan perbedaan konsep dan penggunaan abstract class dan interface.]  
   **Jawaban:** Perbedaan antara abstract class dan interface terletak pada konsep dan cara penggunaannya, di mana abstract class digunakan sebagai kerangka dasar yang dapat menyimpan atribut (state) dan method dengan maupun tanpa implementasi, tetapi tidak dapat diinstansiasi secara langsung. Abstract class cocok digunakan ketika beberapa class memiliki perilaku dan data dasar yang sama. Sementara itu, interface berfungsi sebagai kontrak yang mendefinisikan kemampuan tertentu tanpa bergantung pada satu hierarki class, sehingga satu class dapat mengimplementasikan lebih dari satu interface. Interface lebih tepat digunakan untuk menambahkan perilaku atau fitur tertentu ke berbagai class yang tidak harus saling berhubungan secara langsung.

2. [Mengapa multiple inheritance lebih aman dilakukan dengan interface pada Java?]  
   **Jawaban:** Multiple inheritance lebih aman dilakukan dengan interface pada Java karena interface tidak menyimpan state (atribut) dan hanya mendefinisikan kontrak method, sehingga tidak menimbulkan konflik implementasi seperti diamond problem yang bisa terjadi jika sebuah class mewarisi lebih dari satu class induk. Dengan interface, Java memastikan bahwa setiap class yang mengimplementasikannya harus menyediakan implementasi sendiri, sehingga struktur program tetap jelas, aman, dan mudah dikontrol. 

3. [Pada contoh Agri-POS, bagian mana yang paling tepat menjadi abstract class dan mana yang menjadi interface? Jelaskan alasannya.]  
   **Jawaban:** Pembayaran adalah abstract class yang tepat karena semua jenis pembayaran memiliki struktur dan data dasar yang sama (invoiceNo dan total), serta membutuhkan kerangka method seperti biaya() dan prosesPembayaran(). Sementara Validatable dan Receiptable tepat menjadi interface karena keduanya mendefinisikan kemampuan tambahan—validasi OTP/PIN dan cetak struk—yang tidak harus dimiliki semua metode pembayaran, dan bisa diterapkan pada beberapa class sekaligus. 
   )
