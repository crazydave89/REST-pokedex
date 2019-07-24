package pl.home.pokedex.restcontroller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.home.pokedex.model.Pokedex;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/")
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
}
