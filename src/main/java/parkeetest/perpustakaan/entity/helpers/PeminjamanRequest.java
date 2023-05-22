package parkeetest.perpustakaan.entity.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PeminjamanRequest {
    private Long bukuId;
    private Long peminjamId;
    private int periode;
}
