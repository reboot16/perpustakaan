package parkeetest.perpustakaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parkeetest.perpustakaan.entity.Peminjaman;
import parkeetest.perpustakaan.entity.constant.PeminjamanStatus;

import java.util.Date;
import java.util.List;

public interface PeminjamanRepository extends JpaRepository<Peminjaman, Long> {
    List<Peminjaman> findPeminjamanByStatus(PeminjamanStatus status);
    List<Peminjaman> findPeminjamanByPeminjam(Long peminjamId);
    List<Peminjaman> findPeminjamanByBuku(Long bukuId);
}
