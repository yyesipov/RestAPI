package api.controller;

import api.repository.CharRepository;
import api.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RestController
@RequestMapping(path="/api")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ControllerREST {


    @Autowired
    private CharRepository charRepository;


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


    public Character addNewCharacter (Character character){
        return charRepository.save(character);
    }


}
