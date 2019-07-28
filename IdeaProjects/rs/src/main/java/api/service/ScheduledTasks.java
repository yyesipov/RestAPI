package api.service;


import api.controller.ControllerREST;
import api.model.input.MainEntity;
import api.model.input.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import api.model.forDB.Character;
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

@Component
@Service
public class ScheduledTasks {

    static final String GET_ENDPOINT_URL = "https://rickandmortyapi.com/api/character";
    static final String POST_ENDPOINT_URL = "http://localhost:8080/api/character/post";
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    //    @Scheduled(cron = "0 * * * * ?")
    @Scheduled(fixedRate = 10000)
    public static void getAndSaveCharacters() {

        ControllerREST controllerREST = new ControllerREST();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<MainEntity> result = restTemplate.exchange(GET_ENDPOINT_URL, HttpMethod.GET, null,
                MainEntity.class);

        List<Result> resultList = result.getBody().getResults();

        if (resultList != null) {
            for (Result res : resultList) {
                controllerREST.addNewCharacter(res);
//                System.out.println(res.toString());
            }
            logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        }
    }


    }






