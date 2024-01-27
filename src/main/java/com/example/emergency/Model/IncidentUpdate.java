package com.example.emergency.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

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
    private LocalDateTime currentTime;

    public IncidentUpdate() {
        //TimeZone.setDefault(TimeZone.getTimeZone("Asia/Colombo"));
        this.currentTime = LocalDateTime.now(ZoneId.of("Asia/Colombo"));
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "IncidentUpdate{" +
                "id='" + id + '\'' +
                ", locationName='" + locationName + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", department='" + department + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", currentTime=" + currentTime +
                '}';
    }
}
