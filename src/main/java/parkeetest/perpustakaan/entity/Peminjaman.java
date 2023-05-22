package parkeetest.perpustakaan.entity;

import jakarta.persistence.*;
import lombok.*;
import parkeetest.perpustakaan.entity.constant.PeminjamanStatus;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "peminjaman")
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "peminjam_id")
    private Peminjam peminjam;

    @ManyToOne
    @JoinColumn(name = "buku_id")
    private Buku buku;

    @Column(nullable = false)
    private Date tanggalPeminjaman;

    @Column(nullable = false)
    private int periode;

    @Column(nullable = false)
    private Date tanggalPengembalian;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PeminjamanStatus status;
}
