package com.example.PokemonProject.repository;

import com.example.PokemonProject.model.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface PokemonRepository extends MongoRepository<List<Pokemon>,String> {
}
