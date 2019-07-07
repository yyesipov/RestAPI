package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Controller
@RequestMapping(path="/demo")
public class MainController {


    @Autowired
    private CharRepository charRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewCharacter (
            @RequestParam String name, @RequestParam String status,
            @RequestParam String species, @RequestParam String gender,
            @RequestParam String image, @RequestParam String url) throws Exception{
        Character character = new Character();
        character.setName(name);
        character.setStatus(status);
        character.setSpecies(species);
        character.setGender(gender);
        character.setImage(image);
        character.setUrl(url);
        charRepository.save(character);
        return "Saved";
    }

    @GetMapping(path = "/all")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public @ResponseBody
    Iterable<Character> getAllCharacters(){
        return charRepository.findAll();
    }

    @GetMapping(path = "/{keyword}")
    public @ResponseBody
    Iterable<Character> getCharByKeyword(@PathVariable("keyword") String keyword){
        return charRepository.findCharByKeyword(keyword);
    }

    @GetMapping(path = "/rnd")
    public @ResponseBody
   Character getRandomChar(){
        return charRepository.getRandomChar();
    }

}
