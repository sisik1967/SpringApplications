package com.yazarlar.HW.beans;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@Entity
public class Yazar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long yazarID;
    @NonNull
    private String yazarAdi;
    //@DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME);
    private LocalDate dogumTarihi;
    private String tur;
}
