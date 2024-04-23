package com.example.emergency.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="ServiceUsers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceUser {
    @Id
    private String id;
    private String serviceName;
    private String serviceType;
    private String serviceDescription = "";
    private String email;
    private String serviceImg = "";
    private String serviceRegnumber;
    private String servicePnumber;
    private String serviceAddress;
    private String password;
    private String Role = "ServiceUsers";
    private boolean approved = false;
}
