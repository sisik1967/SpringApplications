package com.yazarlar.HW.bootstraps;

import com.yazarlar.HW.beans.Yazar;
import com.yazarlar.HW.repository.YazarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class YazarBootstrap implements CommandLineRunner {
    @Autowired
    YazarRepository yazarRepository;

    @Override
    public void run(String... args) throws Exception {
        Yazar yazar1 = new Yazar();
        yazar1.setYazarAdi("Yasar Kemal");
        yazar1.setTur("Roman");
        yazar1.setDogumTarihi(LocalDate.parse("1923-10-06"));
        yazarRepository.save(yazar1);

        yazarRepository.save(Yazar.builder().yazarAdi("Resat Nuri Gultekin").tur("Roman").dogumTarihi(LocalDate.parse("1889-11-25")).build());
        yazarRepository.save(new Yazar(10001L, "Omer Seyfettin", LocalDate.parse("1884-03-11"), "Hikaye"));
        yazarRepository.save(new Yazar("Can Yucel"));


    }
}