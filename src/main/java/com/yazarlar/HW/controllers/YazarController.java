package com.yazarlar.HW.controllers;

import com.yazarlar.HW.beans.Yazar;
import com.yazarlar.HW.repository.YazarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yazar")
public class YazarController {
    @Autowired
    YazarRepository yazarRepository;

    @GetMapping
    public List<Yazar> getAllYazar() {
        return yazarRepository.findAll();
    }

    @GetMapping("/{id}")
    public Yazar getYazarById(@PathVariable Long id) {
        return yazarRepository.findById(id).get();
    }


    @PostMapping(consumes = "application/json")
    public List<Yazar> addYazar(@RequestBody Yazar yazar)
    {
        yazarRepository.save(yazar);
        return  yazarRepository.findAll();
    }

    @PutMapping(consumes = "application/json")
    public List<Yazar> replaceYazarList(@RequestBody List<Yazar> yazarList)
    {
        yazarRepository.deleteAll();
        yazarRepository.saveAll(yazarList);
        return  yazarRepository.findAll();
    }

   @PutMapping(value="/{id}", consumes = "application/json" )
    public List<Yazar> replaceYazar(@PathVariable Long id, @RequestBody Yazar yazar)
    {
        yazarRepository.deleteById(id);
        yazarRepository.save(yazar);

        return yazarRepository.findAll();

    }

    @PatchMapping(value="/{id}", consumes = "application/json" )
    public List<Yazar> updateYazar(@PathVariable Long id, @RequestBody Yazar yeniYazar)
    {
        Yazar aktifYazar = yazarRepository.findById(id).get();

        aktifYazar.setYazarAdi(yeniYazar.getYazarAdi());
        aktifYazar.setTur(yeniYazar.getTur());
        aktifYazar.setDogumTarihi(yeniYazar.getDogumTarihi());

        yazarRepository.save(aktifYazar);
        return yazarRepository.findAll();
    }

    @DeleteMapping(value="/{id}" )
    public List<Yazar> deleteYazar(@PathVariable Long id)
    {
        yazarRepository.deleteById(id);
        return yazarRepository.findAll();
    }

    @DeleteMapping()
    public List<Yazar> deleteAllYazars()
    {
        yazarRepository.deleteAll();
        return yazarRepository.findAll();
    }
}