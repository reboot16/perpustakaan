package parkeetest.perpustakaan.service;

import parkeetest.perpustakaan.entity.Buku;

import java.util.List;

public interface BukuService {
    public Buku tambahBuku(Buku buku);
    public Buku updateBuku(Buku buku);
    public List<Buku> getAllBuku();
    public Buku getBukuById(Long bukuId);

    public Buku tambahJumlahBuku(Long bukuId, int jumlah);
}
