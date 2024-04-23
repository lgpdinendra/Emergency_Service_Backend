package com.example.emergency.Repository;

import com.example.emergency.Model.IncidentUpdate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;


public interface IncidentUpdateRepository extends MongoRepository<IncidentUpdate, String> {
    List<IncidentUpdate> findBycurrentTimeBetween(Date startDate, Date endDate);
}

