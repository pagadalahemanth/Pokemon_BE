package com.example.PokemonProject.service;

import com.example.PokemonProject.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PokemonProject.repository.PokemonRepository;

import java.util.List;

@Service
public class PokemonImpl implements IPokemonService{

    @Autowired
    private PokemonRepository pokemonRepository;
    @Override
    public List<Pokemon> savePokemon(List<Pokemon> pokemon) {
        return pokemonRepository.save(pokemon);
    }
}
