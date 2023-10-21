package com.example.PokemonProject.service;

import com.example.PokemonProject.model.Pokemon;

import java.util.List;

public interface IPokemonService {
    public List<Pokemon> savePokemon(List<Pokemon> pokemon);
}
