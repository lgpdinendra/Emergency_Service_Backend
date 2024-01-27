package com.example.emergency.Service;

import com.example.emergency.Model.IncidentUpdate;
import com.example.emergency.Repository.IncidentUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentUpdateService {

    @Autowired
    private IncidentUpdateRepository incidentUpdateRepository;

    public IncidentUpdate saveIncident(IncidentUpdate incident) {
        return incidentUpdateRepository.save(incident);
    }

    public List<IncidentUpdate> getAllIncident() {
        return incidentUpdateRepository.findAll();
    }
}

