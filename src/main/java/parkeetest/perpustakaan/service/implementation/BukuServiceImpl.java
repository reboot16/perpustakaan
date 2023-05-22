package parkeetest.perpustakaan.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import parkeetest.perpustakaan.entity.Buku;
import parkeetest.perpustakaan.repository.BukuRepository;
import parkeetest.perpustakaan.service.BukuService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BukuServiceImpl implements BukuService {

    private BukuRepository repository;
    @Override
    public Buku tambahBuku(Buku buku) {
        return repository.save(buku);
    }

    @Override
    public Buku updateBuku(Buku buku) {
        Buku existingBuku = repository.findById(buku.getId()).get();
        existingBuku.setJudul(buku.getJudul());
        existingBuku.setPenulis(buku.getPenulis());
        existingBuku.setTanggalTerbit(buku.getTanggalTerbit());
        existingBuku.setCategory(buku.getCategory());

        Buku updatedBuku = repository.save(existingBuku);
        return updatedBuku;
    }

    @Override
    public List<Buku> getAllBuku() {
        return repository.findAll();
    }

    @Override
    public Buku getBukuById(Long bukuId) {
        Optional<Buku> buku = repository.findById(bukuId);
        return buku.get();
    }
}
