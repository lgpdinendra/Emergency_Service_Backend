package com.example.emergency.Service;

import lombok.Data;

import java.time.Month;

@Data
public class IncidentCountByMonth {
    private Month month;
    private int incidentCount;

    public IncidentCountByMonth(Month month, int incidentCount) {
        this.month = month;
        this.incidentCount = incidentCount;
    }
}
