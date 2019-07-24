package pl.home.pokedex.restcontroller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.home.pokedex.model.Pokedex;
import pl.home.pokedex.model.Pokemon;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/pokedex")
public class PokedexController {

    private Pokedex pokedex;

    @PostConstruct
    public void loadPokedex(){
        ObjectMapper objectMapper= new ObjectMapper();
        Pokedex thePokedex=null;
        try {
            thePokedex = objectMapper.readValue(new File("pokedex.json"), Pokedex.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pokedex=thePokedex;
    }

    @GetMapping("/fullList")
    public Pokedex showPokedex(){
        return pokedex;
    }

    @GetMapping("/{id}")
    public Pokemon showPokemonById(@PathVariable int id){
        Pokemon resultPokemon=null;
        for (Pokemon pokemon : pokedex.getPokemon()) {
            if (pokemon.getId()==id){
                resultPokemon=pokemon;
            }
        }
        return resultPokemon;
    }

    @GetMapping("/type-{searchType}")
    public List<Pokemon> showSpecyficTypeOfPokemons(@PathVariable String searchType){

        List<Pokemon> pokemonList = new ArrayList<>();

        for (Pokemon pokemon : pokedex.getPokemon()) {
            for (String type : pokemon.getType()) {
                if ((type.toLowerCase()).equals(searchType)){
                    pokemonList.add(pokemon);
                }
            }
        }
        return pokemonList;
    }
}
