/*
package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo")
public class MainController {

    @Autowired
    private CharRepository charRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewCharacter (
            @RequestParam String name, @RequestParam String status,
            @RequestParam String species, @RequestParam String gender,
            @RequestParam String image, @RequestParam String url){
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
    public @ResponseBody Iterable<Character> getAllCharacters(){
        return  charRepository.findAll();
    }

}
*/
