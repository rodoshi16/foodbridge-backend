package com.rodoshi.googlemapsAPI.controller;
import com.rodoshi.googlemapsAPI.Model.FoodBankData;
import com.rodoshi.googlemapsAPI.Model.MapData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// This marks the class as a controller for Spring boot (framework being used)
// Takes care of mapping request data to the handler method
@RestController
public class MapController {

    private static final String API_KEY = "AIzaSyBUfLl8pAPb847igRrMfqYOTdWWFgD-RiA";

    public MapController(){
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/foodbanks")
    /* This annotation maps HTTP GET requests in this handler method in the Spring controller class
    (api/maps) is the URL endpoint that the backend listens to when a request is sent to this URL.
    A request could be http://localhost:8080/api/foodbanks since we know Tomcat is running on port 8080
    When a request is sent to this URL, getMapInfo() is called
     */

    public List<FoodBankData> getFoodBankInfo(@RequestParam double lat, @RequestParam double lng, @RequestParam int radius){
        List<FoodBankData> foodBankDataList = new ArrayList<FoodBankData>();

        String url = String.format(
                "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%f,%f&radius=%d&type=shelter&keyword=food+bank&key=%s",
                lat, lng, radius, API_KEY
        );

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response != null && response.containsKey("results")) {
            List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");

            for (Map<String, Object> result : results) {
                String name = (String) result.get("name");
                String address = (String) result.get("vicinity");
                Map<String, Object> geometry = (Map<String, Object>) result.get("geometry");
                Map<String, Object> location = (Map<String, Object>) geometry.get("location");
                double latitude = (double) location.get("lat");
                double longitude = (double) location.get("lng");

                FoodBankData foodBank = new FoodBankData(latitude, longitude, name, address, "Unknown", "Unknown");
                foodBankDataList.add(foodBank);
            }
        }
        return foodBankDataList;


    }


}
