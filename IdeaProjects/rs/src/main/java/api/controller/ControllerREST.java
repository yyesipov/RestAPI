package api.controller;

import api.model.forDB.Character;
import api.repository.CharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@RestController
@RequestMapping(path="/api")
@Produces(value = {MediaType.APPLICATION_JSON})
public class ControllerREST {

    @Autowired
    private CharRepository charRepository;

    @GetMapping(path = "/characters", produces = "application/json")
    public @ResponseBody
    Iterable<Character> getAllCharacters(){
        return charRepository.findAll();
    }

    @GetMapping(path = "/character/{keyword}", produces = "application/json")
    public @ResponseBody
    List<Character> getCharByKeyword(@PathVariable("keyword") String keyword){
        return charRepository.findCharByKeyword(keyword);
    }

    @GetMapping(path = "/character", produces = "application/json")
    public @ResponseBody
    Character getRandomChar(){
        return charRepository.getRandomChar();
    }


}
