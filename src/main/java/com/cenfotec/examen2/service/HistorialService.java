package com.cenfotec.examen2.service;


import com.cenfotec.examen2.domain.Atleta;
import com.cenfotec.examen2.domain.Historial;

import java.util.List;
import java.util.Optional;

public interface HistorialService {
    public void save(Historial historial);
    public Optional<Historial> get(Long id);
    public List<Historial> getAllByAtleta(Atleta atleta);

}
