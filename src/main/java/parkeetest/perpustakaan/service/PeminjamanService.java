package parkeetest.perpustakaan.service;

import parkeetest.perpustakaan.entity.Peminjaman;
import parkeetest.perpustakaan.entity.helpers.PeminjamanRequest;

import java.util.List;

public interface PeminjamanService {
    Peminjaman tambahPeminjaman(PeminjamanRequest peminjamanRequest);

    Peminjaman peminjamanDikembalikan(Long peminjamanId);

    Peminjaman peminjamanTerlambat(Long peminjamanId);

    List<Peminjaman> getAllPeminjaman();

    List<Peminjaman> getPengembalianTerlambat();

    Peminjaman getPeminjamanById(Long peminjamanId);

    List<Peminjaman> getPengembalianOnTime();
}
