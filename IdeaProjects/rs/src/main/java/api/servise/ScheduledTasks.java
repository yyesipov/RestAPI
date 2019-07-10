package api.servise;

//import api.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import api.model.Character;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class ScheduledTasks {

    static final String GET_ENDPOINT_URL = "https://rickandmortyapi.com/api/character";
    static final String POST_ENDPOINT_URL = "http://localhost:8080/api/character/post";
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

//    @Scheduled(cron = "0 * * * * ?")
    @Scheduled(fixedRate = 10000)
    public static void getAndSaveCharacters() {

       /* // HttpHeaders
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");

        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method, and Headers.
        ResponseEntity<String> response = restTemplate.exchange(GET_ENDPOINT_URL, //
                HttpMethod.GET, entity, String.class);

        String result = response.getBody();

        System.out.println(result);*/





        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity < String > entity = new HttpEntity < String > ("parameters", headers);

        ResponseEntity<Character> result = restTemplate.exchange(GET_ENDPOINT_URL, HttpMethod.GET, entity,
                Character.class);

        System.out.println(result);
/*

        Character[] list = restTemplate.getForObject(GET_ENDPOINT_URL, Character[].class);
        System.out.println("Character: " + list.toString());
*/


       /* if (result != null) {
            for (Character ch : result) {*/

                restTemplate.postForObject(POST_ENDPOINT_URL, result, Character.class);
                               
//            }

        logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }






}
