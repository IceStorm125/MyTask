package com.Andrey.TestTask.rest;

import com.Andrey.TestTask.DTO.VisitDTO;
import com.Andrey.TestTask.model.Visit;
import com.Andrey.TestTask.service.ClientService;
import com.Andrey.TestTask.service.SportComplexService;
import com.Andrey.TestTask.service.VisitService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/visit",produces = "application/json")
@Api(value = "Visits controller",produces = MediaType.APPLICATION_JSON_VALUE)
public class VisitsController {

    private final VisitService visitService;
    private final ClientService clientService;
    private final SportComplexService sportComplexService;

    @Autowired
    public VisitsController(VisitService visitService, ClientService clientService, SportComplexService sportComplexService) {
        this.visitService = visitService;
        this.clientService = clientService;
        this.sportComplexService = sportComplexService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Visit>> getVisits(){
        return new ResponseEntity<>(visitService.getAll(),HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<VisitDTO> addNewVisit(@RequestBody VisitDTO visitDTO){
        visitService.save(visitDTO);
        return new ResponseEntity<>(visitDTO, HttpStatus.OK);
    }
}
