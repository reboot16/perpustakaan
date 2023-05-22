package parkeetest.perpustakaan.service;

import parkeetest.perpustakaan.entity.Peminjam;

import java.util.List;

public interface PeminjamService  {
    Peminjam createPeminjam(Peminjam peminjam);

    Peminjam getPeminjamById(Long peminjamId);

    List<Peminjam> getAllPeminjam();

    Peminjam updatePeminjam(Long peminjamId, Peminjam peminjam);
}
