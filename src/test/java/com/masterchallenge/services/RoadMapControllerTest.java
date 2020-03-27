package com.masterchallenge.services;


import com.masterchallenge.controller.RoadMapController;

import static org.hamcrest.Matchers.containsString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@WebMvcTest(RoadMapController.class)
public class RoadMapControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RoadMapService roadMapService;

    @Test
    public void givenOnlyOrigin_thenGetNo(){
        String origin = "Boston";
        String destination = null;
        try {
            BDDMockito.given(roadMapService.areCitiesConnected(origin, destination)).willReturn(false);
            mvc.perform(get("/connected").queryParam("origin", origin))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("no")));
        }catch (Exception ignored){

        }
    }

    @Test
    public void givenOnlyDestination_thenGetNo(){
        String origin = null;
        String destination = "New York";
        try {
            BDDMockito.given(roadMapService.areCitiesConnected(origin, destination)).willReturn(false);
            mvc.perform(get("/connected").queryParam("destination", destination))
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("no")));
        }catch (Exception ignored){

        }
    }

    @Test
    public void givenTwoDestinations_thenGetYes(){
        String origin = "Philadelphia";
        String destination = "New York";
        try {
            BDDMockito.given(roadMapService.areCitiesConnected(origin, destination)).willReturn(true);
            mvc.perform(get("/connected")
                        .queryParam("origin", origin)
                        .queryParam("destination", destination)
                        )
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("yes")));
        }catch (Exception ignored){

        }
    }

}
