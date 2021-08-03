package com.cenfotec.examen2.service;

import com.cenfotec.examen2.domain.Atleta;
import com.cenfotec.examen2.domain.Historial;
import com.cenfotec.examen2.repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialServiceImpl implements HistorialService{

    @Autowired
    HistorialRepository repo;


    @Override
    public void save(Historial historial) {
        repo.save(historial);
    }

    @Override
    public Optional<Historial> get(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Historial> getAllByAtleta(Atleta atleta) {
        return repo.findAllByAtleta(atleta);
    }
}
