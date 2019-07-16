package api.servise;

//import api.controller.Controller;
import api.controller.ControllerREST;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import api.model.Character;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
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


        ResponseEntity<JSONObject> result = restTemplate.exchange(GET_ENDPOINT_URL, HttpMethod.GET, null,
                JSONObject.class);
        System.out.println(result);

        JSONObject jsonObject = new JSONObject(result.getBody());
        System.out.println(jsonObject);


//        Gson gson = new Gson();

        String jsonString = jsonObject.getAsString("results");
        System.out.println(jsonString);


        List<JSONArray> jsonArray = JSON.parseArray(jsonString, JSONArray.class);
        System.out.println(jsonArray);



       /* if (result != null) {
            for (Character ch : result) {

                controllerREST.addNewCharacter(ch);
            }

                logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
            }*/


        }
    }


