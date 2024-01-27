package com.example.emergency.Repository;

import com.example.emergency.Model.IncidentUpdate;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IncidentUpdateRepository extends MongoRepository<IncidentUpdate, String> {

}

