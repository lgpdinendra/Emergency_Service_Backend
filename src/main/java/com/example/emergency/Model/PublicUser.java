package com.example.emergency.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="PublicUsers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicUser {
    @Id
    private String id;
    private String public_name;
    private String email;
    private String public_nic;
    private String public_pnumber;
    private String public_address;
    private String password;
    private String Role = "PublicUsers";
    private boolean approved = false;
}
