package parkeetest.perpustakaan.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parkeetest.perpustakaan.entity.Peminjam;
import parkeetest.perpustakaan.service.PeminjamService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/peminjam")
public class PeminjamController {
    private PeminjamService service;

    @PostMapping
    public ResponseEntity<Peminjam> tambahPeminjam(@RequestBody Peminjam peminjam) {
        Peminjam peminjamBaru = service.createPeminjam(peminjam);
        return new  ResponseEntity<>(peminjamBaru, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public  ResponseEntity<Peminjam> getPeminjamById(@PathVariable("id") Long peminjamId) {
        Peminjam peminjam = service.getPeminjamById(peminjamId);
        return new  ResponseEntity<>(peminjam, HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<List<Peminjam>> getAllPeminjam() {
        List<Peminjam> semuaPeminjam  = service.getAllPeminjam();
        return new  ResponseEntity<>(semuaPeminjam, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public  ResponseEntity<Peminjam> updatePeminjam(@PathVariable("id") Long peminjamId, @RequestBody Peminjam peminjam) {
        Peminjam updatedPeminjam = service.updatePeminjam(peminjamId, peminjam);
        return new ResponseEntity<>(updatedPeminjam, HttpStatus.OK);
    }
}
