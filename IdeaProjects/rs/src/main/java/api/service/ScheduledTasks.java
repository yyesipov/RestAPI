package api.service;


import api.controller.ControllerREST;
import api.model.input.MainEntity;
import api.model.input.Result;
import api.repository.CharRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import api.model.forDB.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
@Service
public class ScheduledTasks {

    static final String GET_ENDPOINT_URL = "https://rickandmortyapi.com/api/character";
    static final String POST_ENDPOINT_URL = "http://localhost:8080/api/character/post";
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Autowired
    private CharRepository charRepository;

    //    @Scheduled(cron = "0 * * * * ?")
    @Scheduled(fixedRate = 10000)
    public void getAndSaveCharacters() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<MainEntity> result = restTemplate.exchange(GET_ENDPOINT_URL, HttpMethod.GET, null,
                MainEntity.class);


        List<Result> resultList = result.getBody().getResults();

        if (resultList != null) {
            for (Result res : resultList) {
                addNewCharacter(res);
//                System.out.println(res.toString());
            }
            logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        }
    }

    public void addNewCharacter(Result result){
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

//        if (charRepository != null){

        charRepository.save(character);

  /*          System.out.println("Character " + character.getId() + " is saved!");}
       else {
            System.out.println("ERROR: Not saved - charRepository is null");
        }*/

    }
    }






