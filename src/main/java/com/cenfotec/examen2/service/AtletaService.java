package com.cenfotec.examen2.service;

import com.cenfotec.examen2.domain.Atleta;

import java.util.List;
import java.util.Optional;

public interface AtletaService {
    public void save(Atleta atleta);
    public Optional<Atleta> get(Long id);
    public List<Atleta> getAll();
    public List<Atleta> find(String nombre, String apellido1, String apellido2);


}
