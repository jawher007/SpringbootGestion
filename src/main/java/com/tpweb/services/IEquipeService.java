package com.tpweb.services;

import java.util.List;


import com.tpweb.models.Equipe;

public interface IEquipeService {

    List<Equipe> findAllEquipes();

    Equipe saveEquipe(Equipe equipe);

    Equipe findByID(Long id);

    Equipe editEquipe(Equipe equipe);

    void delete(Equipe equipe);
}
