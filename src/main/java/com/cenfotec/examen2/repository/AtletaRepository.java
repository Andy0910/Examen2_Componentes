package com.cenfotec.examen2.repository;

import com.cenfotec.examen2.domain.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtletaRepository extends JpaRepository<Atleta,Long> {
    List<Atleta> findByNombreContainingOrPrimerApellidoContainingOrSegundoApellidoContaining(String nombre, String apellido1, String apellido2);
}
