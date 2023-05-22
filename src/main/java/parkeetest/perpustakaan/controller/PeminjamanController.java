package parkeetest.perpustakaan.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parkeetest.perpustakaan.entity.Peminjaman;
import parkeetest.perpustakaan.service.PeminjamanService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/peminjaman")
public class PeminjamanController {
    private PeminjamanService service;

    @PostMapping
    public ResponseEntity<Peminjaman> tambahPeminjaman(@RequestBody Peminjaman peminjaman) {
        Peminjaman peminjamanbaru = service.tambahPeminjaman(peminjaman);
        return new ResponseEntity<>(peminjamanbaru, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Peminjaman>> getAllPeminjaman() {
        List<Peminjaman> peminjaman = service.getAllPeminjaman();
        return new ResponseEntity<>(peminjaman, HttpStatus.OK);
    }

    @GetMapping("/terlambat")
    public ResponseEntity<List<Peminjaman>> getPeminjamanTerlambat() {
        List<Peminjaman> peminjaman = service.getPengembalianTerlambat();
        return new ResponseEntity<>(peminjaman, HttpStatus.OK);
    }

    @GetMapping("/dikembalikan")
    public ResponseEntity<List<Peminjaman>> getPengembalianTepatWaktu() {
        List<Peminjaman> peminjaman = service.getPengembalianOnTime();
        return new ResponseEntity<>(peminjaman, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Peminjaman> getPeminjamanById(@PathVariable("id") Long peminjamanId) {
        Peminjaman peminjaman = service.getPeminjamanById(peminjamanId);
        return new ResponseEntity<>(peminjaman, HttpStatus.OK);
    }

    @GetMapping("/peminjam/{peminjamId}")
    public ResponseEntity<List<Peminjaman>> getPeminjamanByPeminjam(@PathVariable("peminjamId") Long peminjamId) {
        List<Peminjaman> peminjaman= service.getPeminjamanByPeminjam(peminjamId);
        return new ResponseEntity<>(peminjaman, HttpStatus.OK);
    }

    @GetMapping("/buku/{bukuId}")
    public ResponseEntity<List<Peminjaman>> getPeminjamanByBuku(@PathVariable("bukuId") Long bukuId) {
        List<Peminjaman> peminjaman= service.getPeminjamanByBuku(bukuId);
        return new ResponseEntity<>(peminjaman, HttpStatus.OK);
    }

    @PutMapping("{id}/terlambat")
    public ResponseEntity<Peminjaman> updatePeminjamanKeTerlambat(@PathVariable("id") Long peminjamanId) {
        Peminjaman peminjamanbaru = service.peminjamanTerlambat(peminjamanId);
        return new ResponseEntity<>(peminjamanbaru, HttpStatus.OK);
    }

    @PutMapping("/dikembalikan")
    public ResponseEntity<Peminjaman> updatePeminjamanKeDikembalikan(@PathVariable("id") Long peminjamanId) {
        Peminjaman peminjamanbaru = service.peminjamanDikembalikan(peminjamanId);
        return new ResponseEntity<>(peminjamanbaru, HttpStatus.OK);
    }
}
