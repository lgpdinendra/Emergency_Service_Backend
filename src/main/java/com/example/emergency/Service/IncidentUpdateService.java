package com.example.emergency.Service;

import com.example.emergency.Model.IncidentUpdate;
import com.example.emergency.Repository.IncidentUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public IncidentUpdate getIncidentById(String id) {
        Optional<IncidentUpdate> optionalIncident = incidentUpdateRepository.findById(id);
        return optionalIncident.orElse(null);
    }
    public boolean deleteIncident(String id) {
        if (incidentUpdateRepository.existsById(id)) {
            incidentUpdateRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

