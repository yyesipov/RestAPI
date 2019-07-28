package api.controller;

import api.model.forDB.Episode;
import api.model.input.Result;
import api.repository.CharRepository;
import api.model.forDB.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;



@Controller
@RequestMapping(path="/api")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ControllerREST {


    @Autowired
   CharRepository charRepository;


    @GetMapping(path = "/characters")
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


    public void addNewCharacter (Result result){
        System.out.println("ControllerREST IN result: " + result.toString());

        Character character = new Character();

        character.setId(result.getId());
        character.setName(result.getName());
        character.setStatus(result.getStatus());
        character.setSpecies(result.getSpecies());
        character.setType(result.getType());
        character.setGender(result.getGender());
        character.setOrigin(result.getOrigin());
        character.setLocation(result.getLocation());
        character.setImage(result.getImage());

        Set<String> s =result.getEpisode();
        for (String str : s) {
            Object obj = str;
            character.setEpisode(null); // TODO!!!
        }

        character.setUrl(result.getUrl());
        character.setCreated(result.getCreated());
        System.out.println("ControllerREST OUT character: " + character.toString());

        if (charRepository != null){
       charRepository.save(character);
            System.out.println("Character " + character.getId() + "is saved!");}
       else {
            System.out.println("ERROR: Not saved - charRepository is null");
        }

    }


}
