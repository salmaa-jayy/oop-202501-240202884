# Laporan Praktikum Minggu 6
Topik: [Desain Arsitektur Sistem dengan UML dan Prinsip SOLID]

## Identitas
- Nama  : [Salma Zaidah]
- NIM   : [240202884]
- Kelas : [3 IKR B]

---

## Tujuan
(
Mahasiswa mampu mengidentifikasi kebutuhan sistem ke dalam diagram UML.
Mahasiswa mampu menggambar UML Class Diagram dengan relasi antar class yang tepat.
Mahasiswa mampu menjelaskan prinsip desain OOP (SOLID).
Mahasiswa mampu menerapkan minimal dua prinsip SOLID dalam kode program.
)

---

## Deskripsi Sistem AgriPOS
(
AgriPOS merupakan sistem Point of Sale (POS) yang dirancang untuk mendukung proses transaksi penjualan produk pertanian, seperti benih tanaman, pupuk, serta perlengkapan dan alat pertanian. Sistem ini bertujuan untuk membantu pencatatan transaksi, pengelolaan produk, dan proses pembayaran secara terkomputerisasi agar lebih cepat dan akurat.

Dalam sistem AgriPOS terdapat dua aktor utama, yaitu:

Admin Bertanggung jawab dalam pengelolaan data produk serta melihat laporan transaksi penjualan.

Kasir Bertugas melakukan proses transaksi penjualan mulai dari pemindaian produk, checkout, hingga pembayaran dan pencetakan struk.


)

---

## Kebutuhan Fungsional Sistem
(
Kebutuhan fungsional yang didukung oleh sistem AgriPOS antara lain:

Autentikasi pengguna (login) dan pengaturan hak akses
Pengelolaan data produk
Pemindaian dan pemilihan produk
Proses checkout transaksi
Pembayaran menggunakan metode tunai dan e-wallet
Pencetakan struk transaksi
)

---

## 1. Perancangan Arsitektur Sistem Menggunakan UML
(
1.1 Use Case Diagram
Use Case Diagram digunakan untuk menunjukkan interaksi antara aktor dengan sistem AgriPOS. Diagram ini melibatkan dua aktor utama, yaitu Admin dan Kasir, yang memiliki peran berbeda dalam sistem.

Aktor
a. Admin
b. Kasir

Use Case Utama
a. Login
b. Kelola Produk
c. Scan Produk
d. Checkout Transaksi
e. Proses Pembayaran
f. Cetak Struk

Relasi UML
a. Use case Checkout Transaksi memiliki relasi <<include>> terhadap Cetak Struk
b. Pembayaran Tunai dan Pembayaran E-Wallet merupakan turunan (generalization) dari Proses Pembayaran

Use Case Diagram ini memberikan gambaran umum fungsi-fungsi yang dapat dijalankan oleh masing-masing aktor dalam sistem.

1.2 Activity Diagram - Proses Checkout
Activity Diagram menggambarkan alur aktivitas yang dilakukan oleh kasir saat memproses transaksi penjualan, mulai dari login hingga pencetakan struk.

Alur Aktivitas
a. Kasir melakukan login
b. Kasir memindai produk
c. Sistem menambahkan produk ke keranjang
d. Kasir memilih metode pembayaran
e. Sistem memvalidasi pembayaran (tunai atau e-wallet)
f. Transaksi berhasil dan struk dicetak

Diagram ini menggunakan swimlane untuk membedakan aktivitas antara Kasir, Sistem, dan Payment Gateway.

1.3 Sequence Diagram - Proses Pembayaran
Sequence Diagram digunakan untuk menggambarkan urutan interaksi antar objek secara kronologis dalam proses pembayaran.

Urutan Interaksi

a. CheckoutService meminta data produk ke ProductService
b. CheckoutService menentukan metode pembayaran
c. Sistem membuat objek PaymentMethod sesuai pilihan pengguna
d. Jika metode e-wallet dipilih, sistem berkomunikasi dengan Payment Gateway
e. Payment Gateway mengirimkan status transaksi
f. Sistem menyimpan data transaksi
g. Sistem menampilkan dan mencetak struk

Sequence Diagram ini membantu memahami alur komunikasi antar komponen sistem secara detail dan berurutan.

1.4 Class Diagram
Class Diagram menggambarkan struktur kelas serta hubungan antar kelas dalam sistem AgriPOS, yang mencerminkan penerapan konsep pemrograman berorientasi objek.

Kelas Domain
a. Product
b. CartItem
c. Cart
d. Transaction

Kelas Service
a. ProductService
b. CartService
c. CheckoutService

Kelas Pembayaran
a. IPaymentMethod (interface)
b. CashPayment
c. EWalletPayment
d. PaymentGateway

Relasi Antar Kelas
a. Composition antara Cart dan CartItem
b. Composition antara Transaction dan CartItem
c. Association antara CheckoutService dan ProductService
d. Inheritance antara IPaymentMethod dengan CashPayment dan EWalletPayment
e. Dependency antara EWalletPayment dan PaymentGateway

Class Diagram ini menunjukkan struktur sistem secara menyeluruh serta hubungan antar kelas yang membentuk sistem AgriPOS.
)

## 2. Penerapan Prinsip Solid
| Prinsip                                   | Penjelasan                                                                                         | Implementasi pada Sistem                                                                                                                                         |
| ----------------------------------------- | -------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **SRP (Single Responsibility Principle)** | Setiap kelas hanya memiliki satu tanggung jawab utama                                              | `CartService` hanya menangani logika pengelolaan keranjang seperti menambah dan menghapus produk, tanpa mencampur proses pembayaran atau penyimpanan data        |
| **OCP (Open-Closed Principle)**           | Sistem dapat dikembangkan tanpa perlu mengubah kode yang sudah ada                                 | Penambahan metode pembayaran baru dapat dilakukan dengan membuat class baru yang mengimplementasikan `IPaymentMethod` tanpa mengubah kode pada `CheckoutService` |
| **LSP (Liskov Substitution Principle)**   | Subclass harus dapat menggantikan superclass tanpa memengaruhi kebenaran program                   | `CashPayment` dan `EWalletPayment` dapat digunakan sebagai objek `IPaymentMethod` tanpa mengubah perilaku sistem                                                 |
| **ISP (Interface Segregation Principle)** | Interface dibuat spesifik dan tidak memaksa kelas mengimplementasikan metode yang tidak dibutuhkan | `IPaymentMethod` hanya berisi metode `pay()` sehingga setiap kelas pembayaran hanya mengimplementasikan fungsi yang relevan                                      |
| **DIP (Dependency Inversion Principle)**  | Modul tingkat tinggi bergantung pada abstraksi, bukan implementasi konkret                         | `CheckoutService` bergantung pada interface `IPaymentMethod`, bukan langsung pada class `CashPayment` atau `EWalletPayment`                                      |

---


## Analisis
(
Berdasarkan perancangan sistem AgriPOS yang telah dilakukan, penggunaan berbagai diagram UML terbukti mampu menggambarkan kebutuhan fungsional serta alur kerja sistem secara jelas, sistematis, dan terstruktur. Use Case Diagram memberikan gambaran hubungan antara aktor Admin dan Kasir dengan fungsi-fungsi utama sistem, sehingga batasan peran dan hak akses masing-masing aktor dapat dipahami dengan baik. Activity Diagram menunjukkan alur proses checkout secara runtut mulai dari proses login, pemindaian produk, pemilihan metode pembayaran, hingga pencetakan struk, sehingga memudahkan pemahaman alur bisnis sistem.

Selanjutnya, Sequence Diagram menggambarkan urutan interaksi antar komponen sistem pada proses pembayaran secara kronologis, termasuk komunikasi dengan Payment Gateway pada metode pembayaran e-wallet. Diagram ini membantu memahami bagaimana data dan kontrol berpindah antar objek dalam sistem. Class Diagram menjelaskan struktur kelas, atribut, metode, serta relasi antar kelas yang digunakan, sehingga memberikan gambaran arsitektur sistem dan penerapan konsep pemrograman berorientasi objek secara menyeluruh.

Penerapan prinsip SOLID pada desain sistem AgriPOS berperan penting dalam meningkatkan kualitas perangkat lunak. Prinsip-prinsip tersebut membantu meningkatkan keterbacaan kode, kemudahan pemeliharaan, serta fleksibilitas sistem. Penggunaan abstraksi melalui interface, khususnya pada modul pembayaran, memungkinkan sistem dikembangkan lebih lanjut tanpa perlu mengubah kelas inti. Dengan demikian, penambahan metode pembayaran baru dapat dilakukan dengan lebih mudah, aman, dan minim risiko terhadap fungsionalitas sistem yang telah ada.
)
---

## Kesimpulan
(
Perancangan arsitektur sistem AgriPOS menggunakan UML dan prinsip SOLID berhasil menghasilkan desain sistem yang terstruktur, modular, dan mudah dikembangkan. Setiap kebutuhan fungsional telah dipetakan dengan baik ke dalam diagram UML dan direalisasikan dalam bentuk kelas dan antarmuka yang saling terhubung.

Dengan pendekatan ini, sistem AgriPOS memiliki potensi untuk dikembangkan lebih lanjut, seperti penambahan metode pembayaran baru atau fitur laporan yang lebih kompleks, tanpa memerlukan perubahan besar pada desain awal. Hal ini menunjukkan bahwa penerapan UML dan prinsip SOLID sangat membantu dalam membangun sistem perangkat lunak yang berkualitas dan berkelanjutan.
)

---

## Quiz
(1. [Jelaskan perbedaan aggregation dan composition serta berikan contoh penerapannya pada desain Anda.]  
   **Jawaban:** a. Aggregation dan Composition merupakan bentuk relasi has-a dalam UML, namun memiliki perbedaan pada tingkat ketergantungan objek.

   b. Aggregation Menunjukkan hubungan kepemilikan yang lemah, di mana objek dapat tetap ada meskipun objek induknya dihapus.
   c. Composition Menunjukkan hubungan kepemilikan yang kuat, di mana objek tidak dapat berdiri sendiri tanpa objek induknya. 

2. [Bagaimana prinsip Open/Closed dapat memastikan sistem mudah dikembangkan?]  
   **Jawaban:** Prinsip Open/Closed Principle (OCP) menyatakan bahwa suatu kelas harus terbuka untuk pengembangan (extension) tetapi tertutup untuk perubahan (modification). Artinya, fitur baru dapat ditambahkan tanpa mengubah kode yang sudah ada. Penerapan pada AgriPOS: Pada sistem AgriPOS, metode pembayaran dirancang menggunakan interface IPaymentMethod. Jika di masa depan ingin menambahkan metode pembayaran baru seperti transfer bank atau QRIS, pengembang cukup membuat kelas baru yang mengimplementasikan IPaymentMethod tanpa mengubah kode pada CheckoutService atau PaymentService. Dengan demikian, risiko bug pada kode lama dapat diminimalkan dan sistem lebih mudah dikembangkan. 

3. [Mengapa Dependency Inversion Principle (DIP) meningkatkan testability? Berikan contoh penerapannya.]  
   **Jawaban:** Dependency Inversion Principle (DIP) menyatakan bahwa modul tingkat tinggi tidak boleh bergantung pada modul tingkat rendah, melainkan bergantung pada abstraksi (interface). Hal ini meningkatkan testability karena ketergantungan konkret dapat digantikan dengan objek tiruan (mock).  
   Contoh penerapan pada AgriPOS: CheckoutService tidak bergantung langsung pada CashPayment atau EWalletPayment, tetapi pada interface IPaymentMethod. Saat melakukan pengujian, pengembang dapat membuat mock payment yang mengimplementasikan IPaymentMethod tanpa harus benar-benar memanggil sistem pembayaran asli. Dengan pendekatan ini, proses pengujian menjadi lebih mudah, cepat, dan tidak bergantung pada sistem eksternal seperti payment gateway.
   )
