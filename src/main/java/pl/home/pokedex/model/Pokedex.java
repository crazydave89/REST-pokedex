package pl.home.pokedex.model;


import java.util.List;

public class Pokedex {

    List<Pokemon> pokemon;

    public Pokedex() {
    }

    public Pokedex(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
}
