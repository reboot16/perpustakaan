package parkeetest.perpustakaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parkeetest.perpustakaan.entity.Buku;

public interface BukuRepository extends JpaRepository<Buku, Long> {
}
