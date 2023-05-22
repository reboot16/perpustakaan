create table buku
(
    id              bigint auto_increment
        primary key,
    category        enum ('comic', 'other', 'physicology', 'religions', 'science') not null,
    deskripsi       varchar(255)                                                   not null,
    judul           varchar(255)                                                   not null,
    jumlah_tersedia int                                                            not null,
    penulis         varchar(255)                                                   not null,
    tanggal_terbit  date                                                           null
);

create table peminjam
(
    id       bigint auto_increment
        primary key,
    email    varchar(255) not null,
    nama     varchar(255) not null,
    nomor_hp varchar(255) not null,
    constraint UK_hdeguq9ri7cwjnejfsa77xe5k
        unique (email)
);

create table peminjaman
(
    id                   bigint auto_increment
        primary key,
    periode              int                                               not null,
    status               enum ('Dikembalikan', 'Dipinjamkan', 'Terlambat') not null,
    tanggal_peminjaman   datetime(6)                                       not null,
    tanggal_pengembalian datetime(6)                                       not null,
    buku_id              bigint                                            null,
    peminjam_id          bigint                                            null,
    constraint FKbnexo76v9lk24oft9jp5e14uj
        foreign key (peminjam_id) references peminjam (id),
    constraint FKei7ilms0t9ck4xhmgvemlfqif
        foreign key (buku_id) references buku (id)
);

