package api.controller;

import api.repository.CharRepository;
import api.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RestController
@RequestMapping(path="/api")
public class ControllerREST {


    @Autowired
    private CharRepository charRepository;


    @GetMapping(path = "/characters")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public @ResponseBody
    Iterable<Character> getAllCharacters(){
        return charRepository.findAll();
    }

    @GetMapping(path = "/character/{keyword}")
    public @ResponseBody
    Iterable<Character> getCharByKeyword(@PathVariable("keyword") String keyword){
        return charRepository.findCharByKeyword(keyword);
    }

    @GetMapping(path = "/character")
    public @ResponseBody
   Character getRandomChar(){
        return charRepository.getRandomChar();
    }

    /*  @GetMapping(path = "/character/add/new")
    public @ResponseBody String addNewCharacter (
            @RequestParam String name, @RequestParam String status,
            @RequestParam String species, @RequestParam String gender,
            @RequestParam String image, @RequestParam String url) {
        Character character = new Character();
        character.setName(name);
        character.setStatus(status);
        character.setSpecies(species);
        character.setGender(gender);
        character.setImage(image);
        character.setUrl(url);
        charRepository.save(character);
        return "Saved";
    }*/

}
