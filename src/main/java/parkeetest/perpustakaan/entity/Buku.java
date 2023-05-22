package parkeetest.perpustakaan.entity;

import jakarta.persistence.*;
import lombok.*;
import parkeetest.perpustakaan.entity.constant.Category;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "buku")
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    private String judul;

    @Column(nullable = false)
    private String penulis;

    @Column(nullable = true)
    private Date tanggalTerbit;

    @Column(nullable = false)
    private String deskripsi;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private int jumlahTersedia;
}
