package parkeetest.perpustakaan.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import parkeetest.perpustakaan.entity.Buku;
import parkeetest.perpustakaan.entity.Peminjam;
import parkeetest.perpustakaan.entity.Peminjaman;
import parkeetest.perpustakaan.entity.constant.PeminjamanStatus;
import parkeetest.perpustakaan.entity.helpers.PeminjamanRequest;
import parkeetest.perpustakaan.repository.BukuRepository;
import parkeetest.perpustakaan.repository.PeminjamRepository;
import parkeetest.perpustakaan.repository.PeminjamanRepository;
import parkeetest.perpustakaan.service.BukuService;
import parkeetest.perpustakaan.service.PeminjamService;
import parkeetest.perpustakaan.service.PeminjamanService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class PeminjamanServiceImpl implements PeminjamanService {
    private PeminjamanRepository repository;
    private PeminjamRepository peminjamRepository;
    private BukuRepository bukuRepository;


    @Override
    public Peminjaman tambahPeminjaman(PeminjamanRequest peminjamanRequest) {
        Buku buku = bukuRepository.findById(peminjamanRequest.getBukuId()).get();
        Peminjam peminjam = peminjamRepository.findById(peminjamanRequest.getPeminjamId()).get();

        Peminjaman peminjamanbaru = new Peminjaman();
        peminjamanbaru.setBuku(buku);
        peminjamanbaru.setPeminjam(peminjam);
        peminjamanbaru.setPeriode(peminjamanRequest.getPeriode());
        peminjamanbaru.setStatus(PeminjamanStatus.Dipinjamkan);
        peminjamanbaru.setTanggalPeminjaman(new Date());
        peminjamanbaru.setTanggalPengembalian(this.determineDueDate(peminjamanbaru.getTanggalPeminjaman(), peminjamanbaru.getPeriode()));

        buku.setJumlahTersedia(buku.getJumlahTersedia()-1);
        bukuRepository.save(buku);

        return repository.save(peminjamanbaru);
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
