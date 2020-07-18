package com.tpweb.services;

import java.util.List;

import com.tpweb.models.Equipe;
import com.tpweb.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplEquipeService implements IEquipeService {


    @Autowired
    EquipeRepository repository;

    @Override
    public List<Equipe> findAllEquipes() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override
    public Equipe saveEquipe(Equipe equipe) {
        // TODO Auto-generated method stub
        return repository.save(equipe);
    }


    @Override
    public Equipe findByID(Long id) {
        return repository.findById(id).get();
    }


    @Override
    public Equipe editEquipe(Equipe equipe) {
        return repository.save(equipe);
    }

    @Override
    public void delete(Equipe equipe) {
        repository.delete(equipe);
    }
}