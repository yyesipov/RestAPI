package api.service;


import api.controller.ControllerREST;
import api.model.forDB.Episode;
import api.model.forDB.Origin;
import api.model.input.Info;
import api.model.input.MainEntity;
import api.model.input.Result;
import api.repository.CharRepository;
import api.repository.LocRepository;
import api.repository.OrigRepository;
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
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Component
@Service
public class ScheduledTasks {

    static final String GET_ENDPOINT_URL = "https://rickandmortyapi.com/api/character/?page=1";
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Autowired
    private CharRepository charRepository;

    @Autowired
    private LocRepository locRepository;

    @Autowired
    private OrigRepository origRepository;

    //    @Scheduled(cron = "0 * * * * ?")
    @Scheduled(fixedRate = 3600000)
    public void getAndSaveCharacters() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<MainEntity> result = restTemplate.exchange(GET_ENDPOINT_URL, HttpMethod.GET, null,
                MainEntity.class);

        long pages = result.getBody().getInfo().getPages();

        for (int i = 1; i <= pages; i++) {
                result = restTemplate.exchange("https://rickandmortyapi.com/api/character/?page=" + i,
                        HttpMethod.GET, null, MainEntity.class);

                List<Result> resultList = result.getBody().getResults();

                if (resultList != null) {
                    for (Result res : resultList) {
                        addNewCharacter(res);
                    }
                }
        }
        logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }

    public void addNewCharacter(Result result){

        Character character = new Character();

        character.setId(result.getId());
        character.setName(result.getName());
        character.setStatus(result.getStatus());
        character.setSpecies(result.getSpecies());
        character.setType(result.getType());
        character.setGender(result.getGender());
        character.setOrigin(result.getOriginIn());
        character.setLocation(result.getLocationIn());
        /*if (origRepository.isExistOrigin(result.getOriginIn().getName()) == null){
            character.setOrigin(result.getOriginIn());
        }
        if (locRepository.isExistLocation(result.getLocationIn().getName()) == null) {
            character.setLocation(result.getLocationIn());
        }*/
        character.setImage(result.getImage());

        List<String> s =result.getEpisode();
        for (String str : s) {
            Object obj = str;
            character.setEpisode(null); // TODO!!!
        }
        character.setUrl(result.getUrl());
        character.setCreated(result.getCreated());

        if (charRepository != null){
        charRepository.save(character);
            System.out.println("Character " + character.getId() + " is saved!" + character.toString());
            /*System.out.println("Character " + character.getId() + " is saved!" +
                    " Locatoin: " + character.getLocation().toString()+ " Origin: " + character.getOrigin().toString()) ;*/}
       else {
            System.out.println("ERROR: Not saved - charRepository is null!");
        }

    }
    }






