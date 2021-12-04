package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.travelspace.type.TravelCategory;
import com.spacefinance.spacefinance.travelspace.type.ThingsToTake;
import com.spacefinance.spacefinance.travelspace.Travel;
import com.spacefinance.spacefinance.travelspace.service.TravelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

@SpringBootTest
class TravelServiceImplTest {
    // TODO: 13.08.2021  

    @Autowired
    private TravelService travelService;

    @Test
    void allTravel() {
    }

    @Test
    void addTravel() {
        Travel newTravel = createNewTravel();

    }

    private Travel createNewTravel() {
        Travel travel = new Travel();
        travel.setCategory(TravelCategory.FAMILY);
        travel.setName("Testing");
        travel.setNumberDays(4);
        travel.setTime(LocalTime.now());
        travel.setThingsToTakes(myList());
        return travel;
    }

    private List<ThingsToTake> myList() {
        // TODO: 13.08.2021 Fix that!
        Travel travel = new Travel();
        List<ThingsToTake> thingsToTakes = travel.getThingsToTakes();
        travel.addToThingsList(new ThingsToTake("szachy",1,false,true));
        travel.addToThingsList(new ThingsToTake("mineralna",3,true,false));
        travel.addToThingsList(new ThingsToTake("photos",1,false,false));
       return thingsToTakes;
    }

    @Test
    void removeTravel() {
    }
}
