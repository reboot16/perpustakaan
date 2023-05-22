package parkeetest.perpustakaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parkeetest.perpustakaan.entity.Peminjam;

public interface PeminjamRepository extends JpaRepository<Peminjam, Long> {
}
