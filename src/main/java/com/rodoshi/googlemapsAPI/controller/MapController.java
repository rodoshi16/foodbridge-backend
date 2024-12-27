package com.rodoshi.googlemapsAPI.controller;
import com.rodoshi.googlemapsAPI.Model.FoodBankData;
import com.rodoshi.googlemapsAPI.Model.MapData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// This marks the class as a controller for Spring boot (framework being used)
// Takes care of mapping request data to the handler method
@RestController
public class MapController {

    public MapController(){
    }

    @GetMapping("/api/foodbanks")
    /* This annotation maps HTTP GET requests in this handler method in the Spring controller class
    (api/maps) is the URL endpoint that the backend listens to when a request is sent to this URL.
    A request could be http://localhost:8080/api/foodbanks since we know Tomcat is running on port 8080
    When a request is sent to this URL, getMapInfo() is called
     */

    public List<FoodBankData> getFoodBankInfo(){
        List<FoodBankData> foodBankDataList = new ArrayList<FoodBankData>();
        FoodBankData f1 = new FoodBankData(43.83850460792738, -79.1133888445666, "St.Paul's Community FoodBank", "1537 Pickering Pkwy, Pickering, ON L1V 6W8", "Open", "Mon - Fri  9am to 5pm, closed on weekends");
        FoodBankData f2 = new FoodBankData(43.77563112092362, -79.17948330860042, "Feed scarborough", "4630 Kingston Rd Unit 16, Scarborough, ON M1E 3V8", "Open", "Mon to Fri 10am to 7pm, 12pm to 5pm on Sat, Sun");
        foodBankDataList.add(f1);
        foodBankDataList.add(f2);
        return foodBankDataList;


    }


}
