package parkeetest.perpustakaan.service;

import parkeetest.perpustakaan.entity.Peminjaman;

import java.util.List;

public interface PeminjamanService {
    Peminjaman tambahPeminjaman(Peminjaman peminjaman);

    Peminjaman peminjamanDikembalikan(Long peminjamanId);

    Peminjaman peminjamanTerlambat(Long peminjamanId);

    List<Peminjaman> getAllPeminjaman();

    List<Peminjaman> getPengembalianTerlambat();

    Peminjaman getPeminjamanById(Long peminjamanId);

    List<Peminjaman> getPengembalianOnTime();

    List<Peminjaman> getPeminjamanByPeminjam(Long peminjamId);

    List<Peminjaman> getPeminjamanByBuku(Long bukuId);
}
