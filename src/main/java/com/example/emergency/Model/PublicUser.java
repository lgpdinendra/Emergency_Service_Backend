package com.example.emergency.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicUser {

    @Id
    private String id;
    private String public_firstname;
    private String public_lastname;
    private String email;
    private String public_nic;
    private String public_pnumber;
    private String public_address;
    private String password;
}
