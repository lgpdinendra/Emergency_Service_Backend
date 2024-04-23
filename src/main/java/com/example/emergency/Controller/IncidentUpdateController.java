package com.example.emergency.Controller;

import com.example.emergency.Model.IncidentUpdate;
import com.example.emergency.Repository.IncidentUpdateRepository;
import com.example.emergency.Service.IncidentCountByMonth;
import com.example.emergency.Service.IncidentUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/incidents")
public class IncidentUpdateController {

    @Autowired
    private IncidentUpdateService incidentUpdateService;

    @GetMapping
    public ResponseEntity<List<IncidentUpdate>> getAllIncident() {
        List<IncidentUpdate> incident = incidentUpdateService.getAllIncident();
        return new ResponseEntity<>(incident, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<IncidentUpdate> saveIncident(@RequestBody IncidentUpdate incident) {
        IncidentUpdate savedIncident = incidentUpdateService.saveIncident(incident);
        return new ResponseEntity<>(savedIncident, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<IncidentUpdate> updateIncident(@PathVariable String id, @RequestBody IncidentUpdate updatedIncident) {
        IncidentUpdate incident = incidentUpdateService.getIncidentById(id);


        if (incident == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        incident.setLocationName(updatedIncident.getLocationName());
        incident.setStatus(updatedIncident.getStatus());
        incident.setType(updatedIncident.getType());
        incident.setDepartment(updatedIncident.getDepartment());
        incident.setLatitude(updatedIncident.getLatitude());
        incident.setLongitude(updatedIncident.getLongitude());
        incident.setCurrentTime(updatedIncident.getCurrentTime());

        IncidentUpdate updatedIncidentData = incidentUpdateService.saveIncident(incident);

        return new ResponseEntity<>(updatedIncidentData, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteIncident(@PathVariable String id) {
        boolean isDeleted = incidentUpdateService.deleteIncident(id);

        if (isDeleted) {
            return ResponseEntity.ok("Incident with ID " + id + " has been deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/incidentCount")
    public long getIncidentCount(){
        return incidentUpdateService.getIncidentCount();
    }

    @GetMapping("/count-by-month")
    public List<IncidentCountByMonth> getIncidentCountByMonth() {
        return incidentUpdateService.getIncidentCountByMonth();
    }

}

