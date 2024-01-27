package com.example.emergency.Controller;

import com.example.emergency.Model.IncidentUpdate;
import com.example.emergency.Service.IncidentUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/report_incident")
public class IncidentUpdateController {

    @Autowired
    private IncidentUpdateService incidentUpdateService;

    @PostMapping
    public ResponseEntity<IncidentUpdate> saveIncident(@RequestBody IncidentUpdate incident) {
        IncidentUpdate savedIncident = incidentUpdateService.saveIncident(incident);
        return new ResponseEntity<>(savedIncident, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<IncidentUpdate>> getAllIncident() {
        List<IncidentUpdate> iincident = incidentUpdateService.getAllIncident();
        return new ResponseEntity<>(iincident, HttpStatus.OK);
    }
}

