package parkeetest.perpustakaan.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parkeetest.perpustakaan.entity.Buku;
import parkeetest.perpustakaan.service.BukuService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/buku")
public class BukuController {
    private BukuService service;

    @PostMapping
    public ResponseEntity<Buku> tambahBuku(@RequestBody Buku buku) {
        Buku addedBuku = service.tambahBuku(buku);
        return new ResponseEntity<>(addedBuku, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Buku> getBukuById(@PathVariable("id") Long bukuId) {
        Buku buku = service.getBukuById(bukuId);
        return new ResponseEntity<>(buku, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Buku>> getAllBuku() {
        List<Buku> semuaBuku = service.getAllBuku();
        return new ResponseEntity<>(semuaBuku, HttpStatus.OK);
    }
}
