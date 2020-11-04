package com.Andrey.TestTask.rest;

import com.Andrey.TestTask.DTO.ClientsInfo;
import com.Andrey.TestTask.service.StatisticsService;
import com.Andrey.TestTask.DTO.SportComplexInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/statistics",produces = "application/json")
@Api(value = "Statistics controller",produces = MediaType.APPLICATION_JSON_VALUE)
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/sport-complex-info")
    public ResponseEntity<List<SportComplexInfo>> getSportComplexesOrderByVisitsInfo(){

        List<Object[]> list = statisticsService.getSportComplexesWithCountOfVisitsInfo();

        List<SportComplexInfo> sportComplexInfos = new ArrayList<>();
        for (Object[] o:list) {
            SportComplexInfo sportComplexInfo = new SportComplexInfo();

            sportComplexInfo.setAddress(o[0].toString());
            sportComplexInfo.setName(o[1].toString());
            sportComplexInfo.setCountOfVisits(Integer.parseInt(o[2].toString()));

            sportComplexInfos.add(sportComplexInfo);
        }

        return new ResponseEntity<>(sportComplexInfos, HttpStatus.OK);
    }

    @GetMapping("/clients-info")
    public ResponseEntity<List<ClientsInfo>> getCountOfClientsVisitsInfo(){
        List<Object[]> list = statisticsService.getCountOfClientsVisitsInfo();

        List<ClientsInfo> clientsInfos = new ArrayList<>();
        for (Object[] o:list){
            ClientsInfo clientsInfo = new ClientsInfo();

            clientsInfo.setFirstName(o[0].toString());
            clientsInfo.setLastName(o[1].toString());
            clientsInfo.setTelNumber(o[2].toString());
            clientsInfo.setCountOfVisits(Integer.parseInt(o[3].toString()));

            clientsInfos.add(clientsInfo);
        }

        return new ResponseEntity<>(clientsInfos,HttpStatus.OK);
    }
}
