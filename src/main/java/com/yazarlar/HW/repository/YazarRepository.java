package com.yazarlar.HW.repository;

import com.yazarlar.HW.beans.Yazar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YazarRepository extends JpaRepository<Yazar, Long> {
}
