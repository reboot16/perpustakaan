package parkeetest.perpustakaan.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import parkeetest.perpustakaan.entity.Buku;
import parkeetest.perpustakaan.entity.Peminjaman;
import parkeetest.perpustakaan.entity.constant.PeminjamanStatus;
import parkeetest.perpustakaan.repository.BukuRepository;
import parkeetest.perpustakaan.repository.PeminjamanRepository;
import parkeetest.perpustakaan.service.PeminjamanService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class PeminjamanServiceImpl implements PeminjamanService {
    private PeminjamanRepository repository;
    private BukuRepository bukuRepository;

    @Override
    public Peminjaman tambahPeminjaman(Peminjaman peminjaman) {
        peminjaman.setStatus(PeminjamanStatus.Dipinjamkan);
        peminjaman.setTanggalPeminjaman(new Date());
        peminjaman.setTanggalPengembalian(this.determineDueDate(peminjaman.getTanggalPeminjaman(), peminjaman.getPeriode()));

        Buku buku = peminjaman.getBuku();
        buku.setJumlahTersedia(-1);
        bukuRepository.save(buku);

        return repository.save(peminjaman);
    }

    @Override
    public Peminjaman peminjamanDikembalikan(Long peminjamanId) {
        Peminjaman peminjaman = repository.findById(peminjamanId).get();
        peminjaman.setStatus(PeminjamanStatus.Dikembalikan);
        return repository.save(peminjaman);
    }

    @Override
    public Peminjaman peminjamanTerlambat(Long peminjamanId) {
        Peminjaman peminjaman = repository.findById(peminjamanId).get();
        peminjaman.setStatus(PeminjamanStatus.Terlambat);
        return repository.save(peminjaman);
    }

    @Override
    public List<Peminjaman> getAllPeminjaman() {
        return repository.findAll();
    }

    @Override
    public List<Peminjaman> getPengembalianTerlambat() {
        return repository.findPeminjamanByStatus(PeminjamanStatus.Terlambat);
    }

    @Override
    public Peminjaman getPeminjamanById(Long peminjamanId) {
        return repository.findById(peminjamanId).get();
    }

    @Override
    public List<Peminjaman> getPengembalianOnTime() {
        return repository.findPeminjamanByStatus(PeminjamanStatus.Dikembalikan);
    }

    private Date determineDueDate(Date date, int period) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, period);
        return calendar.getTime();
    }
}
