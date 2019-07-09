package api.web;

//import api.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import api.model.Character;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTasks {

    static final String GET_ENDPOINT_URL = "https://rickandmortyapi.com/api/character";
    static final String POST_ENDPOINT_URL = "http://localhost:8080/api/character/post";
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

//    @Scheduled(cron = "0 * * * * ?")
    @Scheduled(fixedRate = 10000)
    public static void getAndSaveCharacters() {

        RestTemplate restTemplate = new RestTemplate();

        Character[] list = restTemplate.getForObject(GET_ENDPOINT_URL, Character[].class);

        if (list != null) {
            for (Character ch : list) {
                restTemplate.postForObject(POST_ENDPOINT_URL, ch, Character.class);
            }
        }
        logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }






}
