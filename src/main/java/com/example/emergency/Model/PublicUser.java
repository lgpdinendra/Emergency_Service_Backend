package com.example.emergency.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicUser {

    @Id
    private String publicuser_Id;
    private String public_firstname;
    private String public_lastname;
    private String public_email;
    private String public_phonenumber;
    private String public_address;
    private String publicuser_password;

}
