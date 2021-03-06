package com.cenfotec.examen2.service;

import com.cenfotec.examen2.domain.Atleta;
import com.cenfotec.examen2.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtletaServiceImpl implements AtletaService {

    @Autowired
    AtletaRepository repo;

    @Override
    public void save(Atleta atleta) {
        repo.save(atleta);
    }

    @Override
    public Optional<Atleta> get(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Atleta> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Atleta> find(String nombre, String apellido1, String apellido2) {
        return repo.findByNombreContainingOrPrimerApellidoContainingOrSegundoApellidoContaining(nombre, apellido1, apellido2);
    }
}
