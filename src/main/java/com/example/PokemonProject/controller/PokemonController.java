package com.example.PokemonProject.controller;

import com.example.PokemonProject.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.PokemonProject.service.IPokemonService;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")//client side url
public class PokemonController {
    private IPokemonService iPokemonService;
    private final RestTemplate restTemplate;

    @Lazy
    @Autowired
    public PokemonController(IPokemonService iPokemonService, RestTemplate restTemplate){
        this.iPokemonService = iPokemonService;
        this.restTemplate = restTemplate;
    }
    //Rest Template is used to create applications that consume RESTful Web Services
    //You should declare a Bean for Rest Template to auto wiring the Rest Template object:
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

//    public PokemonController(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

//    @GetMapping("/pokemon")
//    @ResponseStatus(value= HttpStatus.OK)
//    public @ResponseBody List<Pokemon> getAllPokemon() {
//        // Fetch the data from the open source API.
//        String url = "https://pokeapi.co/api/v2/pokemon/ditto";
//        List<Pokemon> pokemonList = restTemplate.getForObject(url, List.class);
//        System.out.println("PokemonList:"+pokemonList);
//        savePokemon(pokemonList);
//        return pokemonList;
//   }
    @GetMapping("/pokemon")
    public ResponseEntity<?> savePokemon(@RequestBody List<Pokemon> pokemonList){
        String url = "https://pokeapi.co/api/v2/pokemon/ditto";
        pokemonList = restTemplate.getForObject(url, List.class);
        return new ResponseEntity<>(iPokemonService.savePokemon(pokemonList), HttpStatus.OK);
    }
}


