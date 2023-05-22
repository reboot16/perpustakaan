# Perpustakaan 
## Asumsi
1. Peminjaman adalah Entity hasil dari relationship buku dan peminjam
2. Data peminjaman di tambahkan dan diupdate manual oleh Admin
3. Ada 3 status peminjaman:
   * _Dipinjamkan_ : Buku dalam proses pinjam
   * _Dikembalikan_ : Buku dikembalikan tepat waktu
   * _Terlambat_ : buku dikembalikan terlambat
4. Periode pinjam dalam satuan hari
5. 2 endpoint tambahan untuk update status peminjaman
   * PUT /api/peminjaman/{id}/dikembalikan
   * PUT /api/peminjaman/{id}/terlambat
## Endpoints
### Peminjam
1. POST /api/peminjam
   * example : http://localhost:8080/api/peminjam
   * Request Body : `{
     "nama": "Abdi aruan",
     "email": "abdiaruan99@gmail.com",
     "nomorHp": "0888888888"
     }`
2. GET /api/peminjam/{id}
   * example: http://localhost:8080/api/peminjam/1
3. GET /api/peminjam
   * example: http://localhost:8080/api/peminjam

### Buku
1. POST /api/buku
    * example : http://localhost:8080/api/buku
    * RequestBody: `{
      "judul": "Money",
      "penulis": "Crystal hederman",
      "tanggalTerbit": "2004-07-30",
      "deskripsi": "Buku terbaru dari Crystal hederman, mengenai Keuangan",
      "category": "other",
      "jumlahTersedia": 2
      }`
2. GET /api/buku/{id}
   * example: http://localhost:8080/api/buku/1
3. GET /api/buku
   * example: http://localhost:8080/api/buku

### Peminjaman
1. POST /api/peminjaman
   * example : http://localhost:8080/api/peminjaman
   * RequestBody: `{
     "bukuId": 1,
     "peminjamId": 1,
     "periode": 14
     }`
2. PUT /api/peminjaman/{id}/terlambat
    * example : http://localhost:8080/api/peminjaman/1/terlambat
3. PUT /api/peminjaman/{id}/dikembalikan
    * example : http://localhost:8080/api/peminjaman/2/dikembalikan
4. Get /api/peminjaman
    * example : http://localhost:8080/api/peminjaman
5. GET /api/peminjaman/{id}
    * example : http://localhost:8080/api/peminjaman/1
6. GET /api/peminjaman/dekembalikan
    * example : http://localhost:8080/api/peminjaman/dikembalikan
7. GET /api/peminjaman/terlambat
    * example : http://localhost:8080/api/peminjaman/terlambat