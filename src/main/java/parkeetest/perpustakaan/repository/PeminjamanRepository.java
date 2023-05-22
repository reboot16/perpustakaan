package parkeetest.perpustakaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parkeetest.perpustakaan.entity.Peminjaman;
import parkeetest.perpustakaan.entity.constant.PeminjamanStatus;

import java.util.List;

public interface PeminjamanRepository extends JpaRepository<Peminjaman, Long> {
    List<Peminjaman> findPeminjamanByStatus(PeminjamanStatus status);
}
