package com.cenfotec.examen2.repository;

import com.cenfotec.examen2.domain.Atleta;
import com.cenfotec.examen2.domain.Historial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialRepository extends JpaRepository<Historial, Long> {
    List<Historial> findAllByAtleta(Atleta atleta);
}
