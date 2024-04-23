package com.example.emergency.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@Document(collection = "ReportIncident")
public class IncidentUpdate {

    @Id
    private String id;
    private String locationName;
    private String status;
    private String type;
    private String department;

    private double latitude;
    private double longitude;
    private LocalDateTime currentTime = LocalDateTime.now();
}
