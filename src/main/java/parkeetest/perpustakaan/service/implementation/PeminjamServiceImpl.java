package parkeetest.perpustakaan.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import parkeetest.perpustakaan.entity.Peminjam;
import parkeetest.perpustakaan.repository.PeminjamRepository;
import parkeetest.perpustakaan.service.PeminjamService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PeminjamServiceImpl implements PeminjamService {
    private PeminjamRepository repository;

    @Override
    public Peminjam createPeminjam(Peminjam peminjam) {
        return repository.save(peminjam);
    }

    @Override
    public Peminjam getPeminjamById(Long peminjamId) {
        Optional<Peminjam> peminjam = repository.findById(peminjamId);
        return peminjam.get();
    }

    @Override
    public List<Peminjam> getAllPeminjam() {
        return repository.findAll();
    }

    @Override
    public Peminjam updatePeminjam(Long PeminjamId, Peminjam peminjam) {
        Peminjam existingPeminjam = repository.findById(PeminjamId).get();
        existingPeminjam.setNama(peminjam.getNama());
        existingPeminjam.setEmail(peminjam.getEmail());
        existingPeminjam.setNomorHp(peminjam.getNomorHp());
        return null;
    }
}
