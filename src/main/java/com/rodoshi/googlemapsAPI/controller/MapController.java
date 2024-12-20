package com.rodoshi.googlemapsAPI.controller;
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

    @GetMapping("/api/maps")
    /* This annotation maps HTTP GET requests in this handler method in the Spring controller class
    (api/maps) is the URL endpoint that the backend listens to when a request is sent to this URL.
    A request could be http://localhost:8080/api/maps since we know Tomcat is running on port 8080
    When a request is sent to this URL, getMapInfo() is called
     */

    public List<MapData> getMapInfo(){
        List<MapData> mapDataList = new ArrayList<MapData>();
        MapData m1 = new MapData(43.6532, -79.3832, 10, "Toronto");
        MapData m2 = new MapData(76.2112, -89.3231, 10, "Pickering");
        mapDataList.add(m1);
        mapDataList.add(m2);
        return mapDataList;

    }


}
